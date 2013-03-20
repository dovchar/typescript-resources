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

    "tsc ${originalFile}".execute().waitFor()

    resource.processedFile = new File(resource.processedFile.parentFile, "${originalFileName.replaceAll('ts', 'js')}")
    resource.sourceUrlExtension = 'js'
    resource.updateActualUrlFromProcessedFile()
  }
}
