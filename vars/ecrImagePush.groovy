def call(String aws_account_id, String region, String ecr_repoName){
    
    sh """
    
    docker login --username AWS --password $(aws ecr get-login-password --region ${region}) ${aws_account_id}.dkr.ecr.${region}.amazonaws.com
    docker push ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest 
    """

}