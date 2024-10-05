-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-09-2024 a las 02:23:40
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `metacine`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actor`
--

CREATE TABLE `actor` (
  `idActor` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `idAdmin` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `butaca`
--

CREATE TABLE `butaca` (
  `idButaca` int(11) NOT NULL,
  `numero` int(11) DEFAULT NULL,
  `fila` char(1) DEFAULT NULL,
  `idSala` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cartelera`
--

CREATE TABLE `cartelera` (
  `idCartelera` int(11) NOT NULL,
  `fechaInicio` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL,
  `idCine` int(11) DEFAULT NULL,
  `idPubli` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cine`
--

CREATE TABLE `cine` (
  `idCine` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `idAdmin` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clasificacion`
--

CREATE TABLE `clasificacion` (
  `idClasificacion` int(11) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `idCompra` int(11) NOT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallecompraentrada`
--

CREATE TABLE `detallecompraentrada` (
  `idDetalleEt` int(11) NOT NULL,
  `idCompra` int(11) DEFAULT NULL,
  `idEntrada` int(11) DEFAULT NULL,
  `idButaca` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallecompraproducto`
--

CREATE TABLE `detallecompraproducto` (
  `idDetallePd` int(11) NOT NULL,
  `idCompra` int(11) DEFAULT NULL,
  `idProducto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallecomprapromo`
--

CREATE TABLE `detallecomprapromo` (
  `idDetallePm` int(11) NOT NULL,
  `idCompra` int(11) DEFAULT NULL,
  `idPromo` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `director`
--

CREATE TABLE `director` (
  `idDirector` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dulceria`
--

CREATE TABLE `dulceria` (
  `idDuleria` int(11) NOT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  `idCine` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrada`
--

CREATE TABLE `entrada` (
  `idEntrada` int(11) NOT NULL,
  `idFuncion` int(11) DEFAULT NULL,
  `idTipoEntrada` int(11) DEFAULT NULL,
  `precio` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funcion`
--

CREATE TABLE `funcion` (
  `idFuncion` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `idCartelera` int(11) DEFAULT NULL,
  `idSala` int(11) DEFAULT NULL,
  `idPelicula` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `idGenero` int(11) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `idioma`
--

CREATE TABLE `idioma` (
  `idIdioma` int(11) NOT NULL,
  `nombre` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `idPelicula` int(11) NOT NULL,
  `duration` time DEFAULT NULL,
  `description` varchar(512) DEFAULT NULL,
  `idIdioma` int(11) DEFAULT NULL,
  `idClasificacion` int(11) DEFAULT NULL,
  `idDirector` int(11) DEFAULT NULL,
  `idGenero` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `idTipoProd` int(11) DEFAULT NULL,
  `idDuleria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `promocion`
--

CREATE TABLE `promocion` (
  `idPromo` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `fechaInicio` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL,
  `idCine` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `publicador`
--

CREATE TABLE `publicador` (
  `idPubli` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reparto`
--

CREATE TABLE `reparto` (
  `idReparto` int(11) NOT NULL,
  `idActor` int(11) DEFAULT NULL,
  `idPelicula` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sala`
--

CREATE TABLE `sala` (
  `idSala` int(11) NOT NULL,
  `capacidad` int(11) DEFAULT NULL,
  `idCine` int(11) DEFAULT NULL,
  `idTipoSala` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoentrada`
--

CREATE TABLE `tipoentrada` (
  `idTipoEntrada` int(11) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoproducto`
--

CREATE TABLE `tipoproducto` (
  `idTipoProd` int(11) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiposala`
--

CREATE TABLE `tiposala` (
  `idTipoSala` int(11) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actor`
--
ALTER TABLE `actor`
  ADD PRIMARY KEY (`idActor`);

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`idAdmin`);

--
-- Indices de la tabla `butaca`
--
ALTER TABLE `butaca`
  ADD PRIMARY KEY (`idButaca`),
  ADD KEY `idSala` (`idSala`);

--
-- Indices de la tabla `cartelera`
--
ALTER TABLE `cartelera`
  ADD PRIMARY KEY (`idCartelera`),
  ADD KEY `idCine` (`idCine`),
  ADD KEY `idPubli` (`idPubli`);

--
-- Indices de la tabla `cine`
--
ALTER TABLE `cine`
  ADD PRIMARY KEY (`idCine`),
  ADD KEY `idAdmin` (`idAdmin`);

--
-- Indices de la tabla `clasificacion`
--
ALTER TABLE `clasificacion`
  ADD PRIMARY KEY (`idClasificacion`);

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`idCompra`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- Indices de la tabla `detallecompraentrada`
--
ALTER TABLE `detallecompraentrada`
  ADD PRIMARY KEY (`idDetalleEt`),
  ADD KEY `idCompra` (`idCompra`),
  ADD KEY `idEntrada` (`idEntrada`),
  ADD KEY `idButaca` (`idButaca`);

--
-- Indices de la tabla `detallecompraproducto`
--
ALTER TABLE `detallecompraproducto`
  ADD PRIMARY KEY (`idDetallePd`),
  ADD KEY `idCompra` (`idCompra`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indices de la tabla `detallecomprapromo`
--
ALTER TABLE `detallecomprapromo`
  ADD PRIMARY KEY (`idDetallePm`),
  ADD KEY `idCompra` (`idCompra`),
  ADD KEY `idPromo` (`idPromo`);

--
-- Indices de la tabla `director`
--
ALTER TABLE `director`
  ADD PRIMARY KEY (`idDirector`);

--
-- Indices de la tabla `dulceria`
--
ALTER TABLE `dulceria`
  ADD PRIMARY KEY (`idDuleria`),
  ADD KEY `idCine` (`idCine`);

--
-- Indices de la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD PRIMARY KEY (`idEntrada`),
  ADD KEY `idFuncion` (`idFuncion`),
  ADD KEY `idTipoEntrada` (`idTipoEntrada`);

--
-- Indices de la tabla `funcion`
--
ALTER TABLE `funcion`
  ADD PRIMARY KEY (`idFuncion`),
  ADD KEY `idCartelera` (`idCartelera`),
  ADD KEY `idSala` (`idSala`),
  ADD KEY `idPelicula` (`idPelicula`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`idGenero`);

--
-- Indices de la tabla `idioma`
--
ALTER TABLE `idioma`
  ADD PRIMARY KEY (`idIdioma`);

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`idPelicula`),
  ADD KEY `idIdioma` (`idIdioma`),
  ADD KEY `idClasificacion` (`idClasificacion`),
  ADD KEY `idDirector` (`idDirector`),
  ADD KEY `idGenero` (`idGenero`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `idDuleria` (`idDuleria`),
  ADD KEY `idTipoProd` (`idTipoProd`);

--
-- Indices de la tabla `promocion`
--
ALTER TABLE `promocion`
  ADD PRIMARY KEY (`idPromo`),
  ADD KEY `idCine` (`idCine`);

--
-- Indices de la tabla `publicador`
--
ALTER TABLE `publicador`
  ADD PRIMARY KEY (`idPubli`);

--
-- Indices de la tabla `reparto`
--
ALTER TABLE `reparto`
  ADD PRIMARY KEY (`idReparto`),
  ADD KEY `idActor` (`idActor`),
  ADD KEY `idPelicula` (`idPelicula`);

--
-- Indices de la tabla `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`idSala`),
  ADD KEY `idCine` (`idCine`),
  ADD KEY `idTipoSala` (`idTipoSala`);

--
-- Indices de la tabla `tipoentrada`
--
ALTER TABLE `tipoentrada`
  ADD PRIMARY KEY (`idTipoEntrada`);

--
-- Indices de la tabla `tipoproducto`
--
ALTER TABLE `tipoproducto`
  ADD PRIMARY KEY (`idTipoProd`);

--
-- Indices de la tabla `tiposala`
--
ALTER TABLE `tiposala`
  ADD PRIMARY KEY (`idTipoSala`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `butaca`
--
ALTER TABLE `butaca`
  ADD CONSTRAINT `butaca_ibfk_1` FOREIGN KEY (`idSala`) REFERENCES `sala` (`idSala`);

--
-- Filtros para la tabla `cartelera`
--
ALTER TABLE `cartelera`
  ADD CONSTRAINT `cartelera_ibfk_1` FOREIGN KEY (`idCine`) REFERENCES `cine` (`idCine`),
  ADD CONSTRAINT `cartelera_ibfk_2` FOREIGN KEY (`idPubli`) REFERENCES `publicador` (`idPubli`);

--
-- Filtros para la tabla `cine`
--
ALTER TABLE `cine`
  ADD CONSTRAINT `cine_ibfk_1` FOREIGN KEY (`idAdmin`) REFERENCES `administrador` (`idAdmin`);

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`);

--
-- Filtros para la tabla `detallecompraentrada`
--
ALTER TABLE `detallecompraentrada`
  ADD CONSTRAINT `detallecompraentrada_ibfk_1` FOREIGN KEY (`idCompra`) REFERENCES `compra` (`idCompra`),
  ADD CONSTRAINT `detallecompraentrada_ibfk_2` FOREIGN KEY (`idEntrada`) REFERENCES `entrada` (`idEntrada`),
  ADD CONSTRAINT `detallecompraentrada_ibfk_3` FOREIGN KEY (`idButaca`) REFERENCES `butaca` (`idButaca`);

--
-- Filtros para la tabla `detallecompraproducto`
--
ALTER TABLE `detallecompraproducto`
  ADD CONSTRAINT `detallecompraproducto_ibfk_1` FOREIGN KEY (`idCompra`) REFERENCES `compra` (`idCompra`),
  ADD CONSTRAINT `detallecompraproducto_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`);

--
-- Filtros para la tabla `detallecomprapromo`
--
ALTER TABLE `detallecomprapromo`
  ADD CONSTRAINT `detallecomprapromo_ibfk_1` FOREIGN KEY (`idCompra`) REFERENCES `compra` (`idCompra`),
  ADD CONSTRAINT `detallecomprapromo_ibfk_2` FOREIGN KEY (`idPromo`) REFERENCES `promocion` (`idPromo`);

--
-- Filtros para la tabla `dulceria`
--
ALTER TABLE `dulceria`
  ADD CONSTRAINT `dulceria_ibfk_1` FOREIGN KEY (`idCine`) REFERENCES `cine` (`idCine`);

--
-- Filtros para la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD CONSTRAINT `entrada_ibfk_1` FOREIGN KEY (`idFuncion`) REFERENCES `funcion` (`idFuncion`),
  ADD CONSTRAINT `entrada_ibfk_2` FOREIGN KEY (`idTipoEntrada`) REFERENCES `tipoentrada` (`idTipoEntrada`);

--
-- Filtros para la tabla `funcion`
--
ALTER TABLE `funcion`
  ADD CONSTRAINT `funcion_ibfk_1` FOREIGN KEY (`idCartelera`) REFERENCES `cartelera` (`idCartelera`),
  ADD CONSTRAINT `funcion_ibfk_2` FOREIGN KEY (`idSala`) REFERENCES `sala` (`idSala`),
  ADD CONSTRAINT `funcion_ibfk_3` FOREIGN KEY (`idPelicula`) REFERENCES `pelicula` (`idPelicula`);

--
-- Filtros para la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD CONSTRAINT `pelicula_ibfk_1` FOREIGN KEY (`idIdioma`) REFERENCES `idioma` (`idIdioma`),
  ADD CONSTRAINT `pelicula_ibfk_2` FOREIGN KEY (`idClasificacion`) REFERENCES `clasificacion` (`idClasificacion`),
  ADD CONSTRAINT `pelicula_ibfk_3` FOREIGN KEY (`idDirector`) REFERENCES `director` (`idDirector`),
  ADD CONSTRAINT `pelicula_ibfk_4` FOREIGN KEY (`idGenero`) REFERENCES `genero` (`idGenero`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`idDuleria`) REFERENCES `dulceria` (`idDuleria`),
  ADD CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`idTipoProd`) REFERENCES `tipoproducto` (`idTipoProd`);

--
-- Filtros para la tabla `promocion`
--
ALTER TABLE `promocion`
  ADD CONSTRAINT `promocion_ibfk_1` FOREIGN KEY (`idCine`) REFERENCES `cine` (`idCine`);

--
-- Filtros para la tabla `reparto`
--
ALTER TABLE `reparto`
  ADD CONSTRAINT `reparto_ibfk_1` FOREIGN KEY (`idActor`) REFERENCES `actor` (`idActor`),
  ADD CONSTRAINT `reparto_ibfk_2` FOREIGN KEY (`idPelicula`) REFERENCES `pelicula` (`idPelicula`);

--
-- Filtros para la tabla `sala`
--
ALTER TABLE `sala`
  ADD CONSTRAINT `sala_ibfk_1` FOREIGN KEY (`idCine`) REFERENCES `cine` (`idCine`),
  ADD CONSTRAINT `sala_ibfk_2` FOREIGN KEY (`idTipoSala`) REFERENCES `tiposala` (`idTipoSala`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
