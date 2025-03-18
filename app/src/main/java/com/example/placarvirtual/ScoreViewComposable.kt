package com.example.placarvirtual

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TeamScore(score: Score){
    var teamScore by remember { mutableIntStateOf(0) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
      Text(text = score.teamName)
      Button(onClick = {
          score.teamScore += 1
      }) {
          Text(text = "+")
      }
      Text(text = "${score.teamScore}")
      Button(onClick = {
          score.teamScore -= 1
      }) {
          Text(text = "-")
      }
    }
}

@Composable
fun ScoreView(team1: Score, team2: Score){
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Row(
            modifier = Modifier.fillMaxSize().background(Color.Blue),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){TeamScore(team1)
          TeamScore(team2)}
    }
}

@Preview(showBackground = true)
@Composable
fun TestScoreView(){
    val team1 = Score("Minecraft", 3)
    val team2 = Score("Terraria", 4)
    ScoreView(team1, team2)
}