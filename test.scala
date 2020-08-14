def prettyPrint(input: String) = {
        var level = 0
        var tabSize = 2
        input.foreach {
          case '(' =>
            level += 1
            println()
            print(("|" + " "*(tabSize-1)) * (level-1))
            print("|" + "-"*(tabSize-1))
          case ')' =>
            level -= 1
          case ',' =>
            println()
            print(("|" + " "*(tabSize-1)) * (level-1))
            print("|" + "-"*(tabSize-1))
          case ' ' =>
          case f => print(f)
        }
}