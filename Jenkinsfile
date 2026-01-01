pipeline {
    // 需要支持Docker的Jenkins节点
    agent {
        any
        // 确保节点有Docker环境
        dockerfile true
    }

    // 环境变量：仅配置本地Docker镜像信息，无仓库相关配置
    environment {
        // 自定义本地镜像名称
        IMAGE_NAME = "attendance"
        // 镜像标签：使用Jenkins构建号，避免镜像覆盖，便于版本追溯
        IMAGE_TAG = "${BUILD_NUMBER}"
        // 完整本地镜像名称
        FULL_IMAGE_NAME = "${IMAGE_NAME}:${IMAGE_TAG}"
    }

    // 核心阶段：移除拉取代码步骤，仅保留编译+本地构建镜像
    stages {
        // 阶段1：代码编译（根据项目语言调整命令，无需手动拉取代码，已由流水线自动拉取）
        stage('代码编译') {
            steps {
                echo "开始编译自动拉取的GitHub项目代码..."
                // Maven编译打包（-DskipTests跳过测试，可按需移除）
                // 代码已在流水线构建前自动拉取到工作空间，直接执行编译命令即可
                sh "mvn clean package -DskipTests"
                echo "代码编译完成！产物存放于target/目录下"
            }
        }

        // 阶段2：本地构建Docker镜像（镜像直接保存到Jenkins服务器本地）
        stage('本地构建Docker镜像') {
            steps {
                echo "开始构建本地Docker镜像：${FULL_IMAGE_NAME}"
                // 构建Docker镜像
                script {
                    docker.build("${FULL_IMAGE_NAME}", ".")
                }
                echo "Docker镜像本地构建完成！镜像已保存至Jenkins服务器"
            }
        }
    }

    // 后置操作：构建结果提示与可选清理
    post {
        success {
            echo "本次Pipeline构建成功！本地镜像信息：${FULL_IMAGE_NAME}"
            echo "登录Jenkins服务器执行 docker images | grep ${IMAGE_NAME} 可查看镜像"
        }
        failure {
            echo "本次Pipeline构建失败！请排查代码编译或Dockerfile配置问题"
        }
        always {
            echo "流水线构建流程结束，执行通用收尾操作..."
            // 若无需保留镜像，可启用以下清理命令（避免磁盘占用过高）
            // sh "docker rmi ${FULL_IMAGE_NAME} || true"
        }
    }
}