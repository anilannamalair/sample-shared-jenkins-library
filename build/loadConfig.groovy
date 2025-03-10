import groovy.json.JsonSlurper

def call(String filePath) {
    def jsonFile = new File(filePath)
    def jsonContent = new JsonSlurper().parseText(jsonFile.text)
    return jsonContent
}
