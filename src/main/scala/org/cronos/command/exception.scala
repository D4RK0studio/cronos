package org.cronos.command

class CommandParserException(message:String) extends Exception(message)

class UnknownCommandException(command:String) extends CommandParserException("Unknown command: " + command)

class UnknownDataTypeException(dataType:String) extends CommandParserException("Unknown DataType: " + dataType)