---

# Spring Boot Application Dockerization Guide

Welcome to the Dockerization guide for your Spring Boot application! This guide will walk you through the process of dockerizing your application along with a MySQL database container.

## Technology Stack

This Spring Boot application utilizes the following technology stack:

- **Spring Boot**: A powerful framework for building Java-based applications.
- **MySQL**: An open-source relational database management system.
- **Docker**: A platform for building, shipping, and running applications in containers.

Feel free to replace any components of this stack with alternatives that better suit your project's needs.

## Prerequisites

Before getting started, make sure you have the following installed on your machine:

- [Docker](https://docs.docker.com/get-docker/): Docker engine for containerization.
- Basic understanding of Docker concepts.

## Dockerizing MySQL Container

To dockerize MySQL, execute the following command:

```bash
docker run -p 3307:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=test mysql:8.0.34
```

This command will create and run a MySQL container with the specified configurations.

## Building Spring Boot Application Docker Image

To build a Docker image for your Spring Boot application, use the following command:

```bash
docker build -t springboot-docker .
```

This command will build a Docker image named `springboot-docker` from the Dockerfile in your project directory.

## Creating Docker Network

Create a Docker network to facilitate communication between containers:

```bash
docker network create spring-net
```

## Connecting Spring Boot Application to MySQL Container

Connect your Spring Boot application container to the MySQL container using the created network:

```bash
docker network connect spring-net mysqldb
```

## Running Spring Boot Application Container

Finally, run your Spring Boot application container with the following command:

```bash
docker run -p 9090:6001 --name spring-app --net spring-net -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_PORT=3307 springboot-docker
```

Replace `spring-app` with the desired name for your container and `springboot-docker` with the name of your Docker image.

## Notes

- Ensure that your Spring Boot application is configured to connect to the MySQL database using the provided environment variables (`MYSQL_HOST`, `MYSQL_USER`, `MYSQL_PASSWORD`, `MYSQL_PORT`).

---
