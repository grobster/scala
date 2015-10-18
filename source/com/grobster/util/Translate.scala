package com.grobster.util

class Translate {
	val translatorBasePath = "https://translate.google.com"
	val poundSymbol = "#"
	val separator = "/"
	val htmlSpace = "%20"

	val languageCodes = Map("English" -> "en", "Armenian" -> "hy", "Bulgarian" -> "bg", "Chinese" -> "zh", "Czech" -> "cs", "Dutch" -> "nl", "French" -> "fr", "German" -> "de", "Italian" -> "it", "Korean" -> "ko", "Portuguese" -> "pt", "Russian" -> "ru", "Spanish" -> "es", "Japanese" -> "ja")
	 
	def replaceSpaceWithHtmlSpace(s: String): String = {
		val htmlSpace = "%20"
		s.trim.replace(" ", htmlSpace)
	}
	
	def completePath(basePath: String, fromLanguage: String, toLanguage: String, text: String): String = {
		val replacedText = replaceSpaceWithHtmlSpace(text)
		val completedPath: String = basePath + separator + poundSymbol + languageCodes(fromLanguage) + separator + languageCodes(toLanguage) + separator + replacedText
		completedPath
	}
}