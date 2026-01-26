package chapter4

class BodyRenderer:IRenderer {
    override fun render(message: Message): String {
        return "<b>${message.body}</b>"
    }
}