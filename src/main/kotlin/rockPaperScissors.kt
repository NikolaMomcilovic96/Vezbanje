fun main(){
    val computer = (1..3).random()
    val player = (1..3).random()

    chosen(computer, player)
    result(computer, player)
}

fun chosen(computer: Int, player: Int){
    print("Comp: ")
    when (computer){
        1 -> println("Rock")
        2 -> println("Paper")
        3 -> println("Scisscors")
    }
    print("Player: ")
    when (player){
        1 -> println("Rock")
        2 -> println("Paper")
        3 -> println("Scisscors")
    }
}

fun result(computer: Int, player: Int){
    if ( computer == 1 ){
        if (player == 2){
            println("Paper beats rock.")
        }else if (player == 3){
            println("Rock beats scissors.")
        }else{
            println("Its even.")
        }
    }else if (computer == 2){
        if (player == 1){
            println("Paper beats rock.")
        }else if (player == 3){
            println("Scissors beat paper.")
        }else{
            println("Its even.")
        }
    }else{
        if (player == 1){
            println("Rock beats scissors.")
        }else if (player == 2){
            println("Scissors beat paper.")
        }else{
            println("Its even.")
        }
    }
}