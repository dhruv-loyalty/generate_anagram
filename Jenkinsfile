template{
  node{
    stage("Clone Repo"){
        Git.clone_repo()
    }
    stage("Build"){
        Maven.build()
    }
    stage("Docker Build"){
        Docker.buildImage()
    }
    stage("Docker Push"){
        Docker.pushImage()
    }
  }
}