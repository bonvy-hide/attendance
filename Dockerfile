# ==================== 构建阶段 ====================
FROM maven:3.9-eclipse-temurin-17 AS builder

WORKDIR /app

# 复制 pom.xml 并下载依赖（利用 Docker 缓存）
COPY pom.xml .
RUN mvn dependency:go-offline -B

# 复制源代码并构建
COPY src ./src
RUN mvn clean package -DskipTests -B

# ==================== 运行阶段 ====================
FROM eclipse-temurin:17-jre

LABEL maintainer="gcliu3@iflytek.com"
LABEL description="考勤管理系统"
LABEL version="1.0.0"

WORKDIR /app

# 设置时区
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# 创建非 root 用户
# RUN groupadd -r attendance && useradd -r -g attendance attendance

# 创建日志目录
RUN mkdir -p /app/logs && chown -R attendance:attendance /app

# 从构建阶段复制 JAR 文件
COPY --from=builder /app/target/*.jar app.jar

# 切换到非 root 用户
# USER attendance

# 暴露端口
EXPOSE 8100

# JVM 参数
# ENV JAVA_OPTS="-Xms256m -Xmx256m -XX:+UseG1GC -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/app/logs/heapdump.hprof"

# 启动命令
CMD ["--server.port=8100", "-Xms256m", "-Xmx512m"]
