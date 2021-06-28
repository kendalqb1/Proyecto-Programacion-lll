-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-06-2021 a las 02:47:13
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectoldb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orders`
--

CREATE TABLE `orders` (
  `id` text COLLATE utf8_spanish_ci NOT NULL,
  `cliente` text COLLATE utf8_spanish_ci NOT NULL,
  `contenido` text COLLATE utf8_spanish_ci NOT NULL,
  `estado` text COLLATE utf8_spanish_ci NOT NULL,
  `fecha` text COLLATE utf8_spanish_ci NOT NULL,
  `costo` text COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `orders`
--

INSERT INTO `orders` (`id`, `cliente`, `contenido`, `estado`, `fecha`, `costo`) VALUES
('1', 'Jorge', 'Decaf  -> Moka. Soy. \n', 'Completada', 'Tue Jun 22 09:34:11 CST 2021', '3220.5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` text COLLATE utf8_spanish_ci NOT NULL,
  `username` text COLLATE utf8_spanish_ci NOT NULL,
  `password` text COLLATE utf8_spanish_ci NOT NULL,
  `rol` text COLLATE utf8_spanish_ci NOT NULL,
  `state` text COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `rol`, `state`) VALUES
('88eb640f-1d58-4142-a310-a67f88527735', 'JorgeLuis19', 'GQSyCZdnZ6bbI2X', 'Vendedor', 'Activo'),
('c4b479d3-3a5b-452b-a961-048bef0d0d50', 'Lourdes0', 'Yk7pRN_P5waG5Iq', 'Vendedor', 'Activo'),
('a1b03f4d-ce2d-46fc-9b02-411334fd9653', 'Martín11', 'pB92Om1pT2mjVkw', 'Vendedor', 'Activo'),
('edd52e5d-a3b9-4e83-8176-4a3e13a1a9f0', 'Andrea53', 'coWYK1DyogcfgL1', 'Vendedor', 'Activo'),
('a447fde4-adbb-4f01-944b-65cc5091f49a', 'Admin', 'admin', 'Admin', 'Activo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`(100));

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD UNIQUE KEY `username` (`username`) USING HASH;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
