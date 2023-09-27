enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario (val nomeUsuario: String)

data class ConteudoEducacional(val nomeConteudo: String, var duracao: Int = 60)

data class Formacao(val nomeFormacao: String, val nivel: Nivel, var conteudos: MutableList<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        
        if(!inscritos.contains(usuario)){
            inscritos.add(usuario)
            println("Usuário ${usuario.nomeUsuario} matriculado na formação $nomeFormacao de nivel $nivel")
        }
        else{
            println("Usuário ${usuario.nomeUsuario} já está matriculado na formação $nomeFormacao de nivel $nivel")
        }
        
    }
    
}

fun main() {
    
    //criar conteudos e formação
    
    val conteudo1 = ConteudoEducacional("Conhecendo a Linguagem Kotlin", 2)
    val conteudo2 = ConteudoEducacional("Estruturas de dados em Kotlin", 4)

    val formacao = Formacao("Desenvolvedor Kotlin", Nivel.INTERMEDIARIO, mutableListOf(conteudo1, conteudo2))
    
    //criar usuarios
    
    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("João")
    
    //matricular usuarios
    
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario2) //tentativa de matricular o usuario2 novamente
    
    //checar inscritos
    
    println("Inscritos na formação ${formacao.nomeFormacao}: ${formacao.inscritos.map { it.nomeUsuario }}")

}