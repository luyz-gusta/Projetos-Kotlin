package br.senai.sp.jandira.login_sigup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.login_sigup.ui.theme.LoginSigUpTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginSigUpTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    signUpScreen()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun signUpScreen() {
    var nameState = rememberSaveable {
        mutableStateOf("")
    }

    var emailState = rememberSaveable {
        mutableStateOf("")
    }

    var phoneState = rememberSaveable {
        mutableStateOf("")
    }

    var passwordState = rememberSaveable {
        mutableStateOf("")
    }


    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Card(
                modifier = Modifier
                    .width(120.dp)
                    .height(40.dp),
                backgroundColor = Color(206, 6, 240),
                shape = RoundedCornerShape(0.dp, 0.dp, 0.dp, 16.dp),
            ) {
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.sign_up),
                    color = Color(206, 6, 240),
                    fontSize = 32.sp,
                    fontWeight = FontWeight(700),
                )
                Text(
                    text = stringResource(id = R.string.new_account),
                    color = Color(160, 156, 156),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(420.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    value = nameState.value,
                    onValueChange = {
                        nameState.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight(400)
                    ),
                    label = { Text(text = stringResource(id = R.string.username)) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = "",
                            tint = Color(206, 6, 240)
                        )
                    },
                    shape = RoundedCornerShape(16.dp),
                )
                OutlinedTextField(
                    value = phoneState.value,
                    onValueChange = {
                        phoneState.value = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight(400)),
                    label = { Text(text = stringResource(id = R.string.phone)) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_phone_android_24),
                            contentDescription = "",
                            tint = Color(206, 6, 240)
                        )
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    shape = RoundedCornerShape(16.dp),
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
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = false,
                        onCheckedChange = null
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = stringResource(id = R.string.over18)
                    )
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    colors = ButtonDefaults.buttonColors(Color(206, 6, 240)),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.create_account),
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(700),
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = stringResource(id = R.string.already_have_an_account),
                    color = Color(160, 156, 156),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(400),
                )
                Spacer(
                    modifier = Modifier.width(5.dp)
                )
                Text(
                    text = stringResource(id = R.string.sign_in),
                    color = Color(206, 6, 240),
                    fontSize = 12.sp,
                    fontWeight = FontWeight(700),
                )
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
                shape = RoundedCornerShape(0.dp, 16.dp, 0.dp, 0.dp),
            ) {
            }
        }
    }
}