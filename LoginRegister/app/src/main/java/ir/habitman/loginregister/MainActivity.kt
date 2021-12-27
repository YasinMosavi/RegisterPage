package ir.habitman.loginregister

import android.os.Bundle
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import ir.habitman.loginregister.ui.theme.LoginRegisterTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginRegisterTheme {
                Surface(color = MaterialTheme.colors.background) {
                    RegisterForm()
                }
            }
        }
    }
}


@Composable
fun Login() {
    Image(
        painter = painterResource(id = R.drawable.login_background),
        contentDescription = "",
        contentScale = ContentScale.Crop,
    )

    Column {
        Box(
            Modifier.padding(
                start = 230.dp,
                top = 300.dp,
                bottom = 100.dp
            )
        ) {
            Text(
                text = "Login",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF666666),
            )
        }

        Column {
            var txt by remember { mutableStateOf("") }
            TextField(
                value = txt,
                onValueChange = { txt = it },
                label = {
                    Text(
                        text = "Username",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFAAAAAA)
                    )
                },
                shape = RoundedCornerShape(topEnd = 48.dp),
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color(0xFFDDDDDD),
                    focusedIndicatorColor = Color(0xFFCCCCCC),
                    backgroundColor = Color(0xFFFAFAFA)
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "",
                        tint = Color(0xFFCCCCCC)
                    )
                },
                modifier = Modifier
                    .width(400.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFDDDDDD),
                        shape = RoundedCornerShape(topEnd = 48.dp),
                    )
            )

            var password by remember { mutableStateOf("") }
            TextField(
                value = password,
                onValueChange = { password = it },
                label = {
                    Text(
                        text = "Password",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFAAAAAA)
                    )
                },
                shape = RoundedCornerShape(bottomEnd = 48.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    backgroundColor = Color(0xFFFAFAFA)
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "",
                        tint = Color(0xFFCCCCCC)
                    )
                },
                modifier = Modifier
                    .width(400.dp)
                    .shadow(
                        elevation = 10.dp,
                        shape = RoundedCornerShape(bottomEnd = 48.dp)
                    )
            )

            Box(Modifier.absoluteOffset(370.dp, (-90).dp)) {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .background(
                            color = Color(0xFF44DD88)
                        )
                        .border(
                            width = 2.dp,
                            color = Color(0x8844AA88),
                            shape = CircleShape
                        )

                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowForward,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }

            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp), Alignment.TopEnd
            ) {
                Text(
                    text = "Forgot ?",
                    fontSize = 16.sp,
                    color = Color(0xFF888888)
                )
            }

            Box(Modifier.fillMaxWidth(), Alignment.TopStart) {
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(
                        topEnd = 48.dp,
                        bottomEnd = 48.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFFFAFAFA),
                        contentColor = Color(0xFFFF8F00),
                    ),
                    modifier = Modifier
                        .shadow(
                            elevation = 5.dp,
                            shape = RoundedCornerShape(
                                topEnd = 48.dp,
                                bottomEnd = 48.dp
                            )
                        )
                        .border(
                            width = 1.dp,
                            color = Color(0xFFDDDDDD),
                            shape = RoundedCornerShape(
                                topEnd = 48.dp,
                                bottomEnd = 48.dp
                            )
                        )
                ) {
                    Text(
                        text = "Register",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }
        }
    }
}


@Composable
fun RegisterForm() {
    Image(
        painter = painterResource(id = R.drawable.register_background),
        contentDescription = "",
        contentScale = ContentScale.Crop,
    )

    Column {
        Box(
            Modifier.padding(
                start = 200.dp,
                top = 300.dp,
                bottom = 100.dp
            )
        ) {
            Text(
                text = "Register",
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF666666),
            )
        }

        Column {
            var txt by remember { mutableStateOf("") }
            TextField(
                value = txt,
                onValueChange = { txt = it },
                label = {
                    Text(
                        text = "Username",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFAAAAAA)
                    )
                },
                shape = RoundedCornerShape(topEnd = 48.dp),
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color(0xFFDDDDDD),
                    focusedIndicatorColor = Color(0xFFCCCCCC),
                    backgroundColor = Color(0xFFFAFAFA)
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "",
                        tint = Color(0xFFCCCCCC)
                    )
                },
                modifier = Modifier
                    .width(400.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFDDDDDD),
                        shape = RoundedCornerShape(topEnd = 48.dp),
                    )
            )

            var txt2 by remember { mutableStateOf("") }
            TextField(
                value = txt2,
                onValueChange = { txt2 = it },
                label = {
                    Text(
                        text = "Email",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFAAAAAA)
                    )
                },
//                shape = RoundedCornerShape(topEnd = 48.dp),
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color(0xFFDDDDDD),
                    focusedIndicatorColor = Color(0xFFCCCCCC),
                    backgroundColor = Color(0xFFFAFAFA)
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "",
                        tint = Color(0xFFCCCCCC)
                    )
                },
                modifier = Modifier
                    .width(400.dp)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFDDDDDD),
//                        shape = RoundedCornerShape(topEnd = 48.dp),
                    )
            )

            var password by remember { mutableStateOf("") }
            TextField(
                value = password,
                onValueChange = { password = it },
                label = {
                    Text(
                        text = "Password",
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFAAAAAA)
                    )
                },
                shape = RoundedCornerShape(bottomEnd = 48.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.textFieldColors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    backgroundColor = Color(0xFFFAFAFA)
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "",
                        tint = Color(0xFFCCCCCC)
                    )
                },
                modifier = Modifier
                    .width(400.dp)
                    .shadow(
                        elevation = 10.dp,
                        shape = RoundedCornerShape(bottomEnd = 48.dp)
                    )
            )

            Box(Modifier.absoluteOffset(370.dp, (-120).dp)) {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .background(
                            color = Color(0xFF44DD88)
                        )
                        .border(
                            width = 2.dp,
                            color = Color(0x8844AA88),
                            shape = CircleShape
                        )

                ) {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }

            Box(Modifier.fillMaxWidth(), Alignment.TopEnd) {
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(
                        topStart= 48.dp,
                        bottomStart = 48.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(0xFFFAFAFA),
                        contentColor = Color(0xFFFF8F00),
                    ),
                    modifier = Modifier
                        .shadow(
                            elevation = 5.dp,
                            shape = RoundedCornerShape(
                                topStart = 48.dp,
                                bottomStart = 48.dp
                            )
                        )
                        .border(
                            width = 1.dp,
                            color = Color(0xFFDDDDDD),
                            shape = RoundedCornerShape(
                                topStart = 48.dp,
                                bottomStart = 48.dp
                            )
                        )
                ) {
                    Text(
                        text = "Login",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }
        }
    }
}

