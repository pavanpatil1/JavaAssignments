var currentQuestion = 0;
var totalQuestion = questions.length;
var score = 0;
var correctanswer = 0;
var wronganswer = 0;


var container = document.getElementById("quizContainer");

var questionel = document.getElementById("question");

var opt1 = document.getElementById("opt1");
var opt2 = document.getElementById("opt2");

var opt3 = document.getElementById("opt3");

var opt4 = document.getElementById("opt4");

var nextButton = document.getElementById("nextbutton");

var result = document.getElementById("result");


function loadQuestion(questionIndex){
    var q = questions[questionIndex];
    questionel.textContent = (questionIndex + 1) + '. ' + q.question;
    opt1.textContent = q.option1;
    opt2.textContent = q.option2;
    opt3.textContent = q.option3;
    opt4.textContent = q.option4;

}


function loadNextQuestion(){



    var selectOPtion = document.querySelector('input[type=radio]:checked');
    if(!selectOPtion){
        alert("Please Select Option");
        return;
    }

    
    var answer = selectOPtion.value;
    answerlist.push(answer);


    
    if(questions[currentQuestion].answer == answer){
        score += 1;
        correctanswer +=1;
        Correctid.push(questions[currentQuestion].id);
    }

    else{
    
        wronganswer+=1;
        wrongid.push(questions[currentQuestion].id);
    }
    selectOPtion.checked = false;
    currentQuestion++;
    if(currentQuestion == totalQuestion - 1){
        nextButton.textContent = 'Finish';

    }
    if(currentQuestion == totalQuestion){


        container.style.display = 'none';
        document.getElementById("resultblock").style.display = 'inline';
        document.getElementById("result").innerHTML = ` <h1> Your Score ${score} / ${totalQuestion} </h1> 
        <div class="r" style="margin-left:80px">
        <h4>Correct Answer ${correctanswer} </h4>  <h4> Wrong Answer ${wronganswer} </h4> <button class="btn" onclick="location.reload()">Start Again</button>
        </div>
        
        `;
        
        console.log("Correct iDs",Correctid);
        console.log("Wrong IDs",wrongid);

        for(var i =0;i<10;i++){
                        

            if(!wrongid.includes(questions[i].id)){
                document.getElementById("que").innerHTML += `
                <h3>Q.${questions[i].question} </h3>
                <label class="option">
                <input type="radio" name="option1" value="1" disabled ><span id="option1">${questions[i].option1} </span>
                    </label>
                    <br><br>
                    <label class="option">
                        <input type="radio" name="option2" value="2"  disabled><span id="opt2">${questions[i].option2}</span>
                    </label><br><br>
                    <label class="option">
                        <input type="radio" name="option3" value="3"  disabled><span id="opt3">${questions[i].option3}</span>
                    </label><br><br>
                    <label class="option">
                        <input type="radio" name="option4" value="4" disabled><span id="opt4">${questions[i].option4}</span>
                    </label><br><br>
                    <span id="correctorwrong" style="color:green">Your answer is Correct.</span><br><br>
                    <span style="color:#006400">Correct Answer : ${questions[i].answer}</span>
                `;
    
            
            
            }

            else{

                document.getElementById("que").innerHTML += `
                <h3>Q.${questions[i].question} </h3>
                <label class="option">
                <input type="radio" name="option1" value="1" disabled ><span id="option1">${questions[i].option1} </span>
                    </label>
                    <br><br>
                    <label class="option">
                        <input type="radio" name="option2" value="2"  disabled><span id="opt2">${questions[i].option2}</span>
                    </label><br><br>
                    <label class="option">
                        <input type="radio" name="option3" value="3"  disabled><span id="opt3">${questions[i].option3}</span>
                    </label><br><br>
                    <label class="option">
                        <input type="radio" name="option4" value="4" disabled><span id="opt4">${questions[i].option4}</span>
                    </label><br><br>
                    <span id="correctorwrong" style="color:red">No, your answer is incorrect.</span><br><br>
                    <span style="color:#006400">Correct Answer : ${questions[i].answer}</span>
                `;
    
            }
          
            
            
          
        }
        return;
    }

    loadQuestion(currentQuestion);

}

var answerlist = [];
var Correctid = [];
var wrongid = [];

loadQuestion(currentQuestion);
