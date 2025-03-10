def call(Map params = [:]) {
    String appName = params.get('appName', 'default-app')
    
    switch(appName) {
        case 'app1':
            // Function Arguments
            echo "🚀 Building ${appName} using Function Arguments..."
            sh "echo Building ${appName}..."
            break

        case 'app2':
            // Named Parameters
            echo "🚀 Building ${appName} using Named Parameters..."
            sh "echo Building ${appName} with version ${params.version}..."
            break

        case 'app3':
            // Configuration File
            def config = loadConfig('config.json')
            def appConfig = config[appName]
            echo "🚀 Building ${appName} using Config File (Version: ${appConfig.version})"
            sh "echo Build Command: ${appConfig.buildCommand}"
            break

        case 'app4':
            // Environment Variables
            def buildEnv = env.BUILD_ENV ?: 'dev'
            echo "🚀 Building ${appName} using Environment Variables (Env: ${buildEnv})..."
            sh "echo Building ${appName} in ${buildEnv} mode..."
            break

        case 'app5':
            // Jenkins Parameters
            echo "🚀 Building ${appName} using Jenkins Input Parameters..."
            sh "echo Deploying ${appName} to ${params.DEPLOY_ENV} environment..."
            break

        case 'app6':
            // Jenkins Credentials
            withCredentials([string(credentialsId: 'build-token', variable: 'BUILD_TOKEN')]) {
                echo "🚀 Building ${appName} using Jenkins Credentials..."
                sh "echo Securely building ${appName} with token: ${BUILD_TOKEN}..."
            }
            break

        default:
            echo "⚠️ Unknown application: ${appName}"
    }
}
