# 🇪🇸 API España

API REST desarrollada con **Spring Boot** para consultar datos administrativos de España: comunidades autónomas, provincias y localidades.

Frontend de documentación en **Astro**: [spainapi.vercel.app](https://spainapi.vercel.app)

---

## 📁 Estructura

```
/BACKEND          → API REST (Spring Boot + Java 17)
/FRONTEND         → Documentación (Astro)
spain.sql         → Base de datos completa (MySQL)
docker-compose.yml → Entorno completo con Docker
```

---

## 🚀 Instalación rápida con Docker (recomendado)

**Requisitos:** Docker + Docker Compose

```bash
git clone https://github.com/PabloGonSan8/Spain.git
cd Spain
cp .env.example .env        # edita .env y pon tu contraseña
docker compose up --build
```

API disponible en `http://localhost:8080`.

> La primera vez tarda ~2-3 minutos mientras MySQL importa los datos.

---

## 🔧 Instalación manual (XAMPP / MySQL)

**Requisitos:** Java 17+, Maven 3.8+, MySQL 8

```bash
# 1. Importar la base de datos
mysql -u root -p < spain.sql

# 2. Ejecutar el backend
cd BACKEND
mvn spring-boot:run
```

API disponible en `http://localhost:8080`.

> En XAMPP el usuario suele ser `root` sin contraseña.

---

## 📘 Endpoints

| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | `/` | Estado de la API `{"status":"ok"}` |
| GET | `/ccaa` | Todas las comunidades autónomas |
| GET | `/ccaa/byName?name={CcAa}` | CCAA por nombre |
| GET | `/ccaa/provincia` | CCAA con sus provincias |
| GET | `/provincias` | Todas las provincias |
| GET | `/provincias/byName?name={Provincia}` | Provincia por nombre |
| GET | `/provincias/localidades` | Provincias con sus localidades |
| GET | `/localidades` | Todas las localidades |
| GET | `/localidades/byName?name={Localidad}` | Localidad por nombre |

---

## 🌐 Frontend

Desplegado en [spainapi.vercel.app/documentacion](https://spainapi.vercel.app/documentacion).

Para ejecutar en local:

```bash
cd FRONTEND
npm install
npm run dev
```

---

## 🤝 Contribuir

1. Fork del repositorio
2. Crea una rama: `feature/nueva-funcionalidad`
3. Realiza tus cambios
4. Envía un Pull Request

---

## 📜 Licencia

MIT — libre uso, modificación y distribución.

## ✨ Autor

Desarrollado por [PabloGonSan8](https://github.com/PabloGonSan8).
