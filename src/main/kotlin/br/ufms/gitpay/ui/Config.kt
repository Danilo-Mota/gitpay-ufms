package br.ufms.gitpay.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import br.ufms.gitpay.ContaBancaria

@Composable
fun ConfigScreen(
    conta: ContaBancaria?,
    onBackClick: () -> Unit
) {
    Text("Configurações")
}