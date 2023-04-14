
CREATE TABLE `fileinfo` (
  `FileName` varchar(50) NOT NULL,
  `FileSize` varchar(50) NOT NULL,
  `FilePath` varchar(50) NOT NULL,
  `FileKey` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `permission` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `keypath` (
  `keyword` varchar(50) DEFAULT NULL,
  `filepath` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `ownerpermission` (
  `oname` varchar(50) NOT NULL,
  `filename` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `permission` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `ownreg` (
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `cpassword` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `perbycoowner` (
  `cownername` varchar(50) NOT NULL,
  `filename` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `access` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `permissiontab` (
  `oname` varchar(50) NOT NULL,
  `file` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `value` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `usrreg` (
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `cpassword` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
