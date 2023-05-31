def buildApp () {
  echo "Building the stage"
  echo "Version is $VERSION"
  sh "mvn --version"
}
def testApp () {
  echo "Testing the stage"
}
def deployApp () {
  echo "Deploying the stage"
}
return this
