package br.ufms.gitpay

class BancoCentral : InterfaceBancoCentral {
    val bancoMap: HashMap<Int, Banco>? = null
    val pixMap: HashMap<String, ContaBancaria>? = null

    override fun registrarBanco(banco: Banco?) {
        banco?.let { bancoMap?.put(it.codigo, it) }
    }

    override fun registrarPix(chave: String?, conta: ContaBancaria?) {
        chave?.let {
            if (conta != null) {
                pixMap?.put(it, conta)
            }
        }
    }

    override fun excluirPix(chave: String?) {
        pixMap?.remove(chave)
    }

    override fun getBanco(codigo: Int): Banco? {
        return bancoMap?.get(codigo)
    }

    override fun getConta(codigoBanco: Int, numero: NumeroBancario?): ContaBancaria? {
        return getBanco(codigoBanco)?.getConta(numero)
    }

    override fun getConta(pix: String?): ContaBancaria? {
        return pixMap?.get(pix)
    }

    override fun depositar(codigoBanco: Int, numeroConta: NumeroBancario?, valor: Int) {
        getConta(codigoBanco, numeroConta)?.depositar(valor.toDouble())
    }

    override fun transferir(
        contaOrigem: ContaBancaria?,
        codigoBancoDestino: Int,
        numeroContaDestino: NumeroBancario?,
        valor: Int
    ) {
        contaOrigem?.transferir(getConta(codigoBancoDestino, numeroContaDestino), valor.toDouble())
    }
}