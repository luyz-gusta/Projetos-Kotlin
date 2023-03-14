package br.senai.sp.jandira.login_sigup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login_sigup.ui.theme.LoginSigUpTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginSigUpTheme {
                loginScreen()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun loginScreen() {

    var emailState = rememberSaveable {
        mutableStateOf("")
    }

    var passwordState = rememberSaveable {
        mutableStateOf("")
    }
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End

            ) {
                Surface(
                    modifier = Modifier
                        .width(120.dp)
                        .height(40.dp),
                    color = Color(206, 6, 240),
                    shape = RoundedCornerShape(0.dp, 0.dp, 0.dp, 16.dp),
                ) {}
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)

            ) {
                Text(
                    text = stringResource(id = R.string.login),
                    color = Color(206, 6, 240),
                    fontSize = 60.sp,
                    fontWeight = FontWeight(700),
                )
                Text(
                    text = stringResource(id = R.string.login_text),
                    color = Color(160, 156, 156),
                    fontSize = 15.sp,
                    fontWeight = FontWeight(400),
                )
                Spacer(
                    modifier = Modifier.height(60.dp)
                )
                OutlinedTextField(
                    value = emailState.value,
                    onValueChange = {
                        emailState.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight(400)),
                    label = { Text(text = stringResource(id = R.string.email)) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_email_24),
                            contentDescription = "",
                            tint = Color(206, 6, 240)
                        )
                    },
                    shape = RoundedCornerShape(16.dp),
                )
                Spacer(
                    modifier = Modifier.height(20.dp)
                )
                OutlinedTextField(
                    value = passwordState.value,
                    onValueChange = {
                        passwordState.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight(400)),
                    label = { Text(text = stringResource(id = R.string.password)) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_lock_24),
                            contentDescription = "",
                            tint = Color(206, 6, 240)
                        )
                    },
                    shape = RoundedCornerShape(16.dp),
                )
                Spacer(
                    modifier = Modifier.height(30.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .width(135.dp)
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(Color(206, 6, 240)),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = stringResource(id = R.string.sign_in).uppercase(),
                                color = Color.White,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(700),
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(30.dp)
                    )
                    Row(
                        modifier = Modifier
                            .wrapContentWidth(),
                    ) {
                        Text(
                            text = stringResource(id = R.string.account),
                            color = Color(160, 156, 156),
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                        )
                        Spacer(
                            modifier = Modifier.width(5.dp)
                        )
                        Text(
                            text = stringResource(id = R.string.sign_up),
                            color = Color(206, 6, 240),
                            fontSize = 12.sp,
                            fontWeight = FontWeight(700),
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Card(
                    modifier = Modifier
                        .width(120.dp)
                        .height(40.dp),
                    backgroundColor = Color(206, 6, 240),
                    shape = RoundedCornerShape(0.dp, 16.dp, 0.dp, 0.dp),) {
                }
            }
        }
    }
}