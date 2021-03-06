package org.grails.plugin.typescriptresources

import org.grails.plugin.resource.mapper.MapperPhase

class TypeScriptResourceMapper {

  static phase = MapperPhase.GENERATION

  static defaultIncludes = ['**/*.ts']

  def map(resource, config) {
    File originalFile = resource.processedFile
    def originalFileName = resource.processedFile.name
    def parentFileName = resource.processedFile.parentFile

    def proc = "tsc ${originalFile}".execute()
    proc.waitFor() 

    def typescriptError = proc.err.text
    
    if(typescriptError.size() > 0) {
      log.error "typescript error: ${typescriptError}" 
    } else {
      println "${originalFileName} seccessfully compiled"
    }

    resource.processedFile = new File(resource.processedFile.parentFile, "${originalFileName.replaceAll('ts', 'js')}")
    resource.sourceUrlExtension = 'js'
    resource.contentType = 'text/javascript'
    resource.updateActualUrlFromProcessedFile()
  }
}
