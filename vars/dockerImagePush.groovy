def call(String project, String imageTag, String hubUser){
    
    withCredentials([usernamePassword
    (credentialsId: 'DockerHubLogin',
     passwordVariable: 'dockerHubPass', 
     usernameVariable: 'dockerHubId')]) {
    
        sh "docker login -u '$dockerHubId' -p '$dockerHubPass'"
    }
    sh "docker image push ${hubUser}/${project}:${imageTag}"
    sh "docker image push ${hubUser}/${project}:latest"

}