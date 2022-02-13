package com.jetpack.backarrowanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jetpack.backarrowanimation.ui.theme.BackArrowAnimationTheme

@ExperimentalAnimationGraphicsApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BackArrowAnimationTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "BackArrow Animations",
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            )
                        }
                    ) {
                        BackArrowAnimation()
                    }
                }
            }
        }
    }
}

@ExperimentalAnimationGraphicsApi
@Composable
fun BackArrowAnimation() {
    var showCloseIcon by remember { mutableStateOf(true) }

    Column {
        Spacer(modifier = Modifier.height(32.dp))

        TopAppBar(
            title = {
                Text(
                    text = "Morphing Animation"
                )
            },
            navigationIcon = {
                AnimatedBackArrowMorphing(showCloseIcon = showCloseIcon)
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        TopAppBar(
            title = {
                Text(
                    text = "Rotation Animation"
                )
            },
            navigationIcon = {
                AnimatedBackArrowRotation(showCloseIcon = showCloseIcon)
            }
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { showCloseIcon = showCloseIcon.not() },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Click Me!")
            }
        }
    }
}

@ExperimentalAnimationGraphicsApi
@Composable
fun AnimatedBackArrowMorphing(
    showCloseIcon: Boolean
) {
    IconButton(
        onClick = { }
    ) {
        val drawableVal = if (showCloseIcon) {
            R.drawable.close_to_back_arrow
        } else {
            R.drawable.back_arrow_to_close
        }

        Icon(
            painter = animatedVectorResource(id = drawableVal).painterFor(atEnd = false),
            contentDescription = "back"
        )
    }
}

@ExperimentalAnimationGraphicsApi
@Composable
fun AnimatedBackArrowRotation(
    showCloseIcon: Boolean
) {
    IconButton(
        onClick = { /*TODO*/ }
    ) {
        val drawableVal = if (showCloseIcon) {
            R.drawable.close_to_arrow_back
        } else {
            R.drawable.arrow_back_to_close
        }

        Icon(
            painter = animatedVectorResource(id = drawableVal).painterFor(atEnd = false),
            contentDescription = "BackArrow"
        )
    }
}



















