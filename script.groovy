def buildJar() {
  echo "Building the images"
  sh "mvn package"
}
def image() {
  withCredentials([usernamePassword(credentialsId: "Docker", usernameVariable: "USR", passwordVariable: "PASS")]) {
  sh "docker build -t hari851995/java:v1.4 ."
  sh "echo $PASS | docker login -u $USR --password-stdin"
  sh "docker push hari851995/java:v1.4"
}
  def deploy() {
    echo "Deploying into server"
}
