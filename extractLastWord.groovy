extractLastWord(parseArgs(args))

def parseArgs(args) {
switch (args.size()) {
    case 1:
        return [targetFile:args[0], outputFile:"defaultOutputFile.txt"]
    case 2:
        return [targetFile:args[0], outputFile:args[1]]
    default:
        System.err.println "usage: groovy extractLastWord.groovy TARGETFILE OUTPUTFILE"
        System.exit 1
}
}

//ファイルの各行の最終語句を抽出
def extractLastWord(argsMap) {

    //対象ファイルと出力先ファイル
    targetFile = new File(argsMap.targetFile)
    outputFile = new File(argsMap.outputFile)

    //各行をsplitして最後の語句を抽出する
    //ただしsize()<=0ならば処理スキップ
    targetFile.eachLine { line->
        if (line.size() > 0) {
            splitedLine = line.split()
            outputFile.append(splitedLine.last() + "\n")
        } else {
            //この行は処理スキップ
        }
    }
}
