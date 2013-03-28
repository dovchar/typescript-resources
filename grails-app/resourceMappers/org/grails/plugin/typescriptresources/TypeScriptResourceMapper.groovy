package org.grails.plugin.typescriptresources

import org.grails.plugin.resource.mapper.MapperPhase

class TypeScriptResourceMapper {

  static phase = MapperPhase.GENERATION

  static defaultExcludes = ['**/*.js']
  static defaultIncludes = ['**/*.ts']

  def map(resource, config) {
    File originalFile = resource.processedFile
    def originalFileName = resource.processedFile.name
    def parentFileName = resource.processedFile.parentFile

    def proc = "tsc ${originalFile}".execute()
    proc.waitFor() 

    def typescriptError = proc.err.text
    
    if(typescriptError.size() > 0) {
      println "typescript error: ${typescriptError}" 
    } else {
      println "info: typescript seccessfully compiled"
    }

    resource.processedFile = new File(resource.processedFile.parentFile, "${originalFileName.replaceAll('ts', 'js')}")
    resource.sourceUrlExtension = 'js'
    resource.contentType = 'text/javascript'
    resource.updateActualUrlFromProcessedFile()
  }
}
