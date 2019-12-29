/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : pt_viramakarya

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-06-29 12:36:54
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `master_jurusan`
-- ----------------------------
DROP TABLE IF EXISTS `master_jurusan`;
CREATE TABLE `master_jurusan` (
  `IDJurusan` varchar(10) NOT NULL,
  `Jurusan` varchar(50) NOT NULL,
  PRIMARY KEY (`IDJurusan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of master_jurusan
-- ----------------------------
INSERT INTO `master_jurusan` VALUES ('JUR-0001', 'Teknik Lingkungan');
INSERT INTO `master_jurusan` VALUES ('JUR-0002', 'Teknik Sipil');
INSERT INTO `master_jurusan` VALUES ('JUR-0003', 'Teknik Arsitektur');
INSERT INTO `master_jurusan` VALUES ('JUR-0004', 'Teknik Geodesi');
INSERT INTO `master_jurusan` VALUES ('JUR-0005', 'Teknik Industri');
INSERT INTO `master_jurusan` VALUES ('JUR-0006', 'Hidrologi');
INSERT INTO `master_jurusan` VALUES ('JUR-0007', 'Teknik Geologi');
INSERT INTO `master_jurusan` VALUES ('JUR-0008', 'Teknik Kimia');
INSERT INTO `master_jurusan` VALUES ('JUR-0009', 'Ekonomi');
INSERT INTO `master_jurusan` VALUES ('JUR-0010', 'Kesehatan Masyarakat');
INSERT INTO `master_jurusan` VALUES ('JUR-0011', 'Hukum');
INSERT INTO `master_jurusan` VALUES ('JUR-0012', 'Pertanian');
INSERT INTO `master_jurusan` VALUES ('JUR-0013', 'Teknik Planologi');
INSERT INTO `master_jurusan` VALUES ('JUR-0014', 'Teknik Informatika');
INSERT INTO `master_jurusan` VALUES ('JUR-0015', 'Biologi');
INSERT INTO `master_jurusan` VALUES ('JUR-0016', 'Teknik Mesin');
INSERT INTO `master_jurusan` VALUES ('JUR-0017', 'Matematika');

-- ----------------------------
-- Table structure for `master_keahlian`
-- ----------------------------
DROP TABLE IF EXISTS `master_keahlian`;
CREATE TABLE `master_keahlian` (
  `IDKeahlian` varchar(10) NOT NULL,
  `Keahlian` varchar(50) NOT NULL,
  PRIMARY KEY (`IDKeahlian`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of master_keahlian
-- ----------------------------
INSERT INTO `master_keahlian` VALUES ('AHLI-0001', 'Ahli Teknik Jalan');
INSERT INTO `master_keahlian` VALUES ('AHLI-0002', 'Ahli Teknik Jembatan');
INSERT INTO `master_keahlian` VALUES ('AHLI-0003', 'Ahli Teknik Bangunan Gedung');
INSERT INTO `master_keahlian` VALUES ('AHLI-0004', 'Ahli Arsitektur');
INSERT INTO `master_keahlian` VALUES ('AHLI-0005', 'Ahli Manajemen Konstruksi');
INSERT INTO `master_keahlian` VALUES ('AHLI-0006', 'Ahli Mekanikal');
INSERT INTO `master_keahlian` VALUES ('AHLI-0007', 'Ahli Elektrikal');
INSERT INTO `master_keahlian` VALUES ('AHLI-0008', 'Ahli Lingkungan');
INSERT INTO `master_keahlian` VALUES ('AHLI-0009', 'Ahli SDA');
INSERT INTO `master_keahlian` VALUES ('AHLI-0010', 'Ahli Bendungan');
INSERT INTO `master_keahlian` VALUES ('AHLI-0011', 'Ahli Kesehatan Masyarakat');
INSERT INTO `master_keahlian` VALUES ('AHLI-0012', 'Anggota Tim Penyusun AMDAL-1');
INSERT INTO `master_keahlian` VALUES ('AHLI-0013', 'Anggota Tim Penyusun AMDAL-2');
INSERT INTO `master_keahlian` VALUES ('AHLI-0014', 'Ketua Tim Penyusun AMDAL');
INSERT INTO `master_keahlian` VALUES ('AHLI-0015', 'Ahli Biologi');
INSERT INTO `master_keahlian` VALUES ('AHLI-0016', 'Ahli Sosekbud');
INSERT INTO `master_keahlian` VALUES ('AHLI-0017', 'Ahli Ekonomi');
INSERT INTO `master_keahlian` VALUES ('AHLI-0018', 'Ahli Sosekbud');
INSERT INTO `master_keahlian` VALUES ('AHLI-0019', 'Ahli Hidrologi');
INSERT INTO `master_keahlian` VALUES ('AHLI-0020', 'Ahli Manajemen dan Rekayasa Lalu Lintas');
INSERT INTO `master_keahlian` VALUES ('AHLI-0021', 'Ahli Bedah');

-- ----------------------------
-- Table structure for `table_bast`
-- ----------------------------
DROP TABLE IF EXISTS `table_bast`;
CREATE TABLE `table_bast` (
  `IDBAST` varchar(10) NOT NULL,
  `TanggalBAST` date NOT NULL,
  `NomorBAST` varchar(100) NOT NULL,
  `IDProyek` varchar(10) NOT NULL,
  PRIMARY KEY (`IDBAST`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of table_bast
-- ----------------------------
INSERT INTO `table_bast` VALUES ('BAST-0001', '2016-09-30', 'KU.02.09/Bw-BAST/PR/10/2016', 'PRYK-0001');
INSERT INTO `table_bast` VALUES ('BAST-0002', '2019-06-25', '9', 'PRYK-0003');

-- ----------------------------
-- Table structure for `table_datatenagaahli`
-- ----------------------------
DROP TABLE IF EXISTS `table_datatenagaahli`;
CREATE TABLE `table_datatenagaahli` (
  `IDTA` varchar(10) NOT NULL,
  `NamaTA` varchar(50) NOT NULL,
  `TempatLahirTA` varchar(50) NOT NULL,
  `TanggalLahirTA` date NOT NULL,
  `JenisKelaminTA` varchar(10) NOT NULL,
  `NomorTeleponTA` varchar(30) NOT NULL,
  `AlamatTA` varchar(300) NOT NULL,
  `PendidikanTerakhirTA` varchar(3) NOT NULL,
  `JurusanTA` varchar(50) NOT NULL,
  `KeahlianTA` varchar(50) NOT NULL,
  `PengalamanTA` varchar(50) NOT NULL,
  `StatusTA` varchar(50) NOT NULL,
  PRIMARY KEY (`IDTA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of table_datatenagaahli
-- ----------------------------
INSERT INTO `table_datatenagaahli` VALUES ('TA-0001', 'Alauddin,ST', 'Langsa', '1989-05-26', 'Pria', '085297673036', 'JL. Sudirman Dusun I RT.001, Gampong Meutia, Langsa Kota, Langsa, Aceh	', 'S1', 'Teknik Mesin', 'Ahli Mekanikal', '10', 'Tidak Dalam Proyek');
INSERT INTO `table_datatenagaahli` VALUES ('TA-0002', 'Aryono Wibowo,ST', 'Surakarta', '1975-11-25', 'Pria', '000', 'Jl. Hangtuah Raya No. 26, Kebayoran Baru, Jakarta Selatan 12120		', 'S1', 'Teknik Sipil', 'Ahli Teknik Jalan', '17', 'Tidak Dalam Proyek');
INSERT INTO `table_datatenagaahli` VALUES ('TA-0003', 'Yusra Siregar, ST', 'Bandung ', '1965-08-20', 'Wanita', '000', 'Jakarta		', 'S1', 'Teknik Lingkungan', 'Ahli Lingkungan', '20', 'Tidak Dalam Proyek');
INSERT INTO `table_datatenagaahli` VALUES ('TA-0004', 'Rahmat Mawardi, S.Pi.,M.Si', 'Jakara', '1984-11-27', 'Pria', '000', 'Bogor', 'S2', 'Teknik Kimia', 'Anggota Tim Penyusun AMDAL-1', '10', 'Tidak Dalam Proyek');
INSERT INTO `table_datatenagaahli` VALUES ('TA-0005', 'Elsa Rifka Disma, SKM', 'Bengkulu', '1986-07-30', 'Wanita', '000', 'Bogor	', 'S1', 'Kesehatan Masyarakat', 'Ahli Kesehatan Masyarakat', '10', 'Sedang Dalam Proyek');
INSERT INTO `table_datatenagaahli` VALUES ('TA-0006', 'Ir.Pudjo Winarno', 'Sidoarjo', '1961-02-19', 'Pria', '000', 'Sidokare Indah Blok AT-2 Sidoarjo', 'S1', 'Teknik Sipil', 'Ahli Bendungan', '15', 'Sedang Dalam Proyek');
INSERT INTO `table_datatenagaahli` VALUES ('TA-0007', 'Drs.Novianto,MT', 'Jakarta', '1966-11-21', 'Pria', '000', 'Jl. Hangtuah Raya No. 26, Kebayoran Baru, Jakarta Selatan 12120', 'S2', 'Teknik Lingkungan', 'Ketua Tim Penyusun AMDAL', '15', 'Tidak Dalam Proyek');
INSERT INTO `table_datatenagaahli` VALUES ('TA-0008', 'Ir. Dyah Indraswari', 'Surabaya', '1966-03-04', 'Wanita', '000', 'Surabaya	', 'S1', 'Teknik Sipil', 'Ahli Hidrologi', '17', 'Tidak Dalam Proyek');
INSERT INTO `table_datatenagaahli` VALUES ('TA-0009', 'budi', 'jakarta', '2018-06-29', 'Pria', '0987777', 'Jakarta', 'S1', 'Matematika', 'Ahli Manajemen Konstruksi', '7', 'Tidak Dalam Proyek');

-- ----------------------------
-- Table structure for `table_proyek`
-- ----------------------------
DROP TABLE IF EXISTS `table_proyek`;
CREATE TABLE `table_proyek` (
  `IDProyek` varchar(10) NOT NULL,
  `NamaProyek` varchar(100) NOT NULL,
  `PemberiKerjaProyek` varchar(100) NOT NULL,
  `LokasiProyek` varchar(50) NOT NULL,
  `NomorKontrakProyek` varchar(100) NOT NULL,
  `PeriodeAwalProyek` date NOT NULL,
  `PeriodeAkhirProyek` date NOT NULL,
  `IDTA` varchar(10) NOT NULL,
  `StatusProyek` varchar(30) NOT NULL,
  PRIMARY KEY (`IDProyek`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of table_proyek
-- ----------------------------
INSERT INTO `table_proyek` VALUES ('PRYK-0001', 'Penyusunan Dokumen Andal Lalin Prov. Jawa Timur, Jawa Tengah dan D.I. Yogyakarta', 'BBPJN V Sidoarjo', 'Sidoarjo', 'KU.02.09/Bw/PR/10/2016', '2016-01-03', '2016-07-31', 'TA-0002', 'Proyek Selesai');
INSERT INTO `table_proyek` VALUES ('PRYK-0002', 'Larap Bendungan Budong-Budong Kab. Mamuju Tengah', 'Satuan Kerja Balai Wilayah Sungai Sulawesi III', 'Palu, Sulawesi', 'HK0203/P&P/BWSSULIII/651', '2018-04-04', '2018-10-30', 'TA-0006', 'Proyek Sedang Berlangsung');
INSERT INTO `table_proyek` VALUES ('PRYK-0003', 'z', 'zz', 'z', '1', '2019-06-24', '2019-06-25', 'TA-0002', 'Proyek Selesai');
INSERT INTO `table_proyek` VALUES ('PRYK-0004', 'zz', 'z', 'z', 'z', '2019-06-23', '2019-06-24', 'TA-0005', 'Proyek Sedang Berlangsung');

-- ----------------------------
-- Table structure for `table_user`
-- ----------------------------
DROP TABLE IF EXISTS `table_user`;
CREATE TABLE `table_user` (
  `IDUser` varchar(10) NOT NULL,
  `Username` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `HakAkses` varchar(10) NOT NULL,
  PRIMARY KEY (`IDUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of table_user
-- ----------------------------
INSERT INTO `table_user` VALUES ('USER-0001', 'Admin', 'Admin', 'Admin');
INSERT INTO `table_user` VALUES ('USER-0002', 'andi', 'andi', 'User');
