package chapter4

class MessageRenderer:IRenderer {
    val subRenderers = listOf<IRenderer>(HeaderRenderer(),BodyRenderer(),FooterRenderer())
    override fun render(message: Message): String {
        return subRenderers.joinToString("") { it.render(message) }
    }


}