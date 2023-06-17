def call(String project, String imageTag, String hubUser){
     
    sh """
    docker image rmi ${hubUser}/${project}:${imageTag}
    docker image rmi  ${hubUser}/${project}:latest
    """

}