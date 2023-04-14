/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fingerprint;

/**
 *

 */
import org.opencv.calib3d.Calib3d;
import org.opencv.core.*;
import org.opencv.features2d.*;
import org.opencv.highgui.Highgui;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class SURFDetector {

    public static String main(String img1, String a1) {
        String filepath = null, id, name="";
        int flag = 0;
        System.out.println(img1+" "+a1);
//        try {
//            id = a;
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/face", "root", "root");
//            Statement stmt = (Statement) con.createStatement();
//            String Sql = "Select * from userreg WHERE uid='" + id + "'";
//            ResultSet rs = stmt.executeQuery(Sql);
//            if (rs.next()) {
//                name = rs.getString("name");
//                filepath = rs.getString("filepath");
                flag = 1;
//              
//            } else {
//                 
//                JOptionPane.showMessageDialog(null, "USER IS NOT PRESENT IN THE DATA BASE ");
//
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
        if (flag == 1) {
            File lib = null;
            String os = System.getProperty("os.name");
            String bitness = System.getProperty("sun.arch.data.model");
            if (os.toUpperCase().contains("WINDOWS")) {
                if (bitness.endsWith("64")) {
                    lib = new File("C:/opencv/build/java/java/x64/opencv_java2413.dll");
                } else {

                    lib = new File("C:/opencv/build/java/java/x86/opencv_java2413.dll");
                }
            }
//            System.out.println(lib.getAbsolutePath());
//            System.load(lib.getAbsolutePath());
            String bookObject = img1;
            String bookScene = a1;
          //  System.out.println("Started....");
         //   System.out.println("Loading images...");
            Mat objectImage = Highgui.imread(bookObject, Highgui.CV_LOAD_IMAGE_COLOR);
            Mat sceneImage = Highgui.imread(bookScene, Highgui.CV_LOAD_IMAGE_COLOR);
            MatOfKeyPoint objectKeyPoints = new MatOfKeyPoint();
            FeatureDetector featureDetector = FeatureDetector.create(FeatureDetector.SURF);
        //    System.out.println("Detecting key points...");
            featureDetector.detect(objectImage, objectKeyPoints);
            KeyPoint[] keypoints = objectKeyPoints.toArray();
          //  System.out.println(keypoints);
            MatOfKeyPoint objectDescriptors = new MatOfKeyPoint();
            DescriptorExtractor descriptorExtractor = DescriptorExtractor.create(DescriptorExtractor.SURF);
          //  System.out.println("Computing descriptors...");
            descriptorExtractor.compute(objectImage, objectKeyPoints, objectDescriptors);
            // Create the matrix for output image.
            Mat outputImage = new Mat(objectImage.rows(), objectImage.cols(), Highgui.CV_LOAD_IMAGE_COLOR);
            Scalar newKeypointColor = new Scalar(255, 0, 0);
           // System.out.println("Drawing key points on object image...");
            Features2d.drawKeypoints(objectImage, objectKeyPoints, outputImage, newKeypointColor, 0);
            // Match object image with the scene image
            MatOfKeyPoint sceneKeyPoints = new MatOfKeyPoint();
            MatOfKeyPoint sceneDescriptors = new MatOfKeyPoint();
           // System.out.println("Detecting key points in background image...");
            featureDetector.detect(sceneImage, sceneKeyPoints);
           // System.out.println("Computing descriptors in background image...");
            descriptorExtractor.compute(sceneImage, sceneKeyPoints, sceneDescriptors);
            Mat matchoutput = new Mat(sceneImage.rows() * 2, sceneImage.cols() * 2, Highgui.CV_LOAD_IMAGE_COLOR);
            Scalar matchestColor = new Scalar(0, 255, 0);
            List<MatOfDMatch> matches = new LinkedList<MatOfDMatch>();
            DescriptorMatcher descriptorMatcher = DescriptorMatcher.create(DescriptorMatcher.FLANNBASED);
          //  System.out.println("Matching object and scene images...");
            descriptorMatcher.knnMatch(objectDescriptors, sceneDescriptors, matches, 2);
           // System.out.println("Calculating good match list...");
            LinkedList<DMatch> goodMatchesList = new LinkedList<DMatch>();
            float nndrRatio = 0.7f;
            for (int i = 0; i < matches.size(); i++) {
                MatOfDMatch matofDMatch = matches.get(i);
                DMatch[] dmatcharray = matofDMatch.toArray();
                DMatch m1 = dmatcharray[0];
                DMatch m2 = dmatcharray[1];
                if (m1.distance <= m2.distance * nndrRatio) {
                    goodMatchesList.addLast(m1);
                }
            }
            System.out.println(goodMatchesList.size());
            if (goodMatchesList.size() >= 60) {
                System.out.println("Object Found!!!");
                List<KeyPoint> objKeypointlist = objectKeyPoints.toList();
                List<KeyPoint> scnKeypointlist = sceneKeyPoints.toList();
                LinkedList<Point> objectPoints = new LinkedList<>();
                LinkedList<Point> scenePoints = new LinkedList<>();
                for (int i = 0; i < goodMatchesList.size(); i++) {
                    objectPoints.addLast(objKeypointlist.get(goodMatchesList.get(i).queryIdx).pt);
                    scenePoints.addLast(scnKeypointlist.get(goodMatchesList.get(i).trainIdx).pt);
                }
                MatOfPoint2f objMatOfPoint2f = new MatOfPoint2f();
                objMatOfPoint2f.fromList(objectPoints);
                MatOfPoint2f scnMatOfPoint2f = new MatOfPoint2f();
                scnMatOfPoint2f.fromList(scenePoints);
                Mat homography = Calib3d.findHomography(objMatOfPoint2f, scnMatOfPoint2f, Calib3d.RANSAC, 3);
                Mat obj_corners = new Mat(4, 1, CvType.CV_32FC2);
                Mat scene_corners = new Mat(4, 1, CvType.CV_32FC2);
                obj_corners.put(0, 0, new double[]{0, 0});
                obj_corners.put(1, 0, new double[]{objectImage.cols(), 0});
                obj_corners.put(2, 0, new double[]{objectImage.cols(), objectImage.rows()});
                obj_corners.put(3, 0, new double[]{0, objectImage.rows()});
              //  System.out.println("Transforming object corners to scene corners...");
                Core.perspectiveTransform(obj_corners, scene_corners, homography);
                Mat img = Highgui.imread(bookScene, Highgui.CV_LOAD_IMAGE_COLOR);
                Core.line(img, new Point(scene_corners.get(0, 0)), new Point(scene_corners.get(1, 0)), new Scalar(0, 255, 0), 4);
                Core.line(img, new Point(scene_corners.get(1, 0)), new Point(scene_corners.get(2, 0)), new Scalar(0, 255, 0), 4);
                Core.line(img, new Point(scene_corners.get(2, 0)), new Point(scene_corners.get(3, 0)), new Scalar(0, 255, 0), 4);
                Core.line(img, new Point(scene_corners.get(3, 0)), new Point(scene_corners.get(0, 0)), new Scalar(0, 255, 0), 4);
          //      System.out.println("Drawing matches image...");
                MatOfDMatch goodMatches = new MatOfDMatch();
                goodMatches.fromList(goodMatchesList);
                Features2d.drawMatches(objectImage, objectKeyPoints, sceneImage, sceneKeyPoints, goodMatches, matchoutput, matchestColor, newKeypointColor, new MatOfByte(), 2);
                Highgui.imwrite("D:\\img\\outputImage.jpg", outputImage);
                Highgui.imwrite("D:\\img\\matchoutput.jpg", matchoutput);
                Highgui.imwrite("D:\\img\\img.jpg", img);
                return "Object Found";
            } else {
                System.out.println("Object Not Found");
            }

            return "Face";
        } else {
            return "No INFO";
        }
    }

}
