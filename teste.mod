var _pin_11,binary;
var _pin_12,binary;
var _pin_21,binary;
var _pin_22,binary;
var _pin_31,binary;
var _pin_32,binary;
var _pin_41,binary;
var _pin_42,binary;
var _pin_51,binary;
var _pin_52,binary;
var _pin_61,binary;
var _pin_62,binary;
var _pin2_11,binary;
var _pin2_12,binary;
var _pin2_21,binary;
var _pin2_22,binary;
var _pin2_31,binary;
var _pin2_32,binary;
var _pin2_41,binary;
var _pin2_42,binary;
var _pin2_51,binary;
var _pin2_52,binary;
var _pin2_61,binary;
var _pin2_62,binary;

maximize z: 
10*_pin_11+
10*_pin_12+
10*_pin_21+
10*_pin_22+
10*_pin_31+
10*_pin_32+
12*_pin_41+
12*_pin_42+
10*_pin_51+
10*_pin_52+
10*_pin_61+
10*_pin_62+
10*_pin2_11+
10*_pin2_12+
12*_pin2_21+
12*_pin2_22+
10*_pin2_31+
10*_pin2_32+
10*_pin2_41+
10*_pin2_42+
10*_pin2_51+
10*_pin2_52+
10*_pin2_61+
10*_pin2_62+# somatorio de todas as disciplinas e horarios de laboratorio = ao céu de 50porcento da carga horária


# somatorio de todas as variaveis da disciplina = carga horaria

s.t. carga_horaria: _pin_11+_pin_12+_pin_21+_pin_22+_pin_31+_pin_32+_pin_41+_pin_42+_pin_51+_pin_52+_pin_61+_pin_62 = 2;
 s.t. carga_horaria1:_pin2_11+_pin2_12+_pin2_21+_pin2_22+_pin2_31+_pin2_32+_pin2_41+_pin2_42+_pin2_51+_pin2_52+_pin2_61+_pin2_62 = 2;

# somatorio_de_todas as disciplinas de um professor por horario <=1 
 s.t. conflito_horario_professor0:_pin_11<= 1; 
s.t. conflito_horario_professor1:_pin_12<= 1; 
s.t. conflito_horario_professor2:_pin_21<= 1; 
s.t. conflito_horario_professor3:_pin_22<= 1; 
s.t. conflito_horario_professor4:_pin_31<= 1; 
s.t. conflito_horario_professor5:_pin_32<= 1; 
s.t. conflito_horario_professor6:_pin_41<= 1; 
s.t. conflito_horario_professor7:_pin_42<= 1; 
s.t. conflito_horario_professor8:_pin_51<= 1; 
s.t. conflito_horario_professor9:_pin_52<= 1; 
s.t. conflito_horario_professor10:_pin_61<= 1; 
s.t. conflito_horario_professor11:_pin_62<= 1; 
s.t. conflito_horario_professor12:_pin2_11<= 1; 
s.t. conflito_horario_professor13:_pin2_12<= 1; 
s.t. conflito_horario_professor14:_pin2_21<= 1; 
s.t. conflito_horario_professor15:_pin2_22<= 1; 
s.t. conflito_horario_professor16:_pin2_31<= 1; 
s.t. conflito_horario_professor17:_pin2_32<= 1; 
s.t. conflito_horario_professor18:_pin2_41<= 1; 
s.t. conflito_horario_professor19:_pin2_42<= 1; 
s.t. conflito_horario_professor20:_pin2_51<= 1; 
s.t. conflito_horario_professor21:_pin2_52<= 1; 
s.t. conflito_horario_professor22:_pin2_61<= 1; 
s.t. conflito_horario_professor23:_pin2_62<= 1; 


# somatorio de todas as disciplinas de uma turma por horario <= 1
s.t. conflito_horario_turma0:_pin_11<= 1; 
s.t. conflito_horario_turma1:_pin2_11<= 1; 
s.t. conflito_horario_turma2:_pin_12<= 1; 
s.t. conflito_horario_turma3:_pin2_12<= 1; 
s.t. conflito_horario_turma4:_pin_21<= 1; 
s.t. conflito_horario_turma5:_pin2_21<= 1; 
s.t. conflito_horario_turma6:_pin_22<= 1; 
s.t. conflito_horario_turma7:_pin2_22<= 1; 
s.t. conflito_horario_turma8:_pin_31<= 1; 
s.t. conflito_horario_turma9:_pin2_31<= 1; 
s.t. conflito_horario_turma10:_pin_32<= 1; 
s.t. conflito_horario_turma11:_pin2_32<= 1; 
s.t. conflito_horario_turma12:_pin_41<= 1; 
s.t. conflito_horario_turma13:_pin2_41<= 1; 
s.t. conflito_horario_turma14:_pin_42<= 1; 
s.t. conflito_horario_turma15:_pin2_42<= 1; 
s.t. conflito_horario_turma16:_pin_51<= 1; 
s.t. conflito_horario_turma17:_pin2_51<= 1; 
s.t. conflito_horario_turma18:_pin_52<= 1; 
s.t. conflito_horario_turma19:_pin2_52<= 1; 
s.t. conflito_horario_turma20:_pin_61<= 1; 
s.t. conflito_horario_turma21:_pin2_61<= 1; 
s.t. conflito_horario_turma22:_pin_62<= 1; 
s.t. conflito_horario_turma23:_pin2_62<= 1; 

# somatorio de todas as disciplinas e horarios indisponiveis de um professor = 0 
s.t. conflito_horario_professor_indisponivel1:_pin_41= 0;
s.t. conflito_horario_professor_indisponivel2:_pin_42= 0;
s.t. conflito_horario_professor_indisponivel3:_pin2_21= 0;
s.t. conflito_horario_professor_indisponivel4:_pin2_22= 0;

# somatorio de todas as disciplinas e horarios indisponiveis delas = 0 
s.t. conflito_horario_proibido:_pin_41+_pin_42= 0;
s.t. conflito_horario_proibido0:_pin2_21+_pin2_22= 0;

# horario arbitrario de disciplina
s.t. horario_arbitrario_disciplina0:_pin2_21 = 1;s.t. horario_arbitrario_disciplina1:_pin2_22 = 1;s.t. horario_arbitrario_disciplina2:_pin_41 = 1;s.t. horario_arbitrario_disciplina3:_pin_42 = 1;
solve;
display _pin_11,_pin_12,_pin_21,_pin_22,_pin_31,_pin_32,_pin_41,_pin_42,_pin_51,_pin_52,_pin_61,_pin_62,_pin2_11,_pin2_12,_pin2_21,_pin2_22,_pin2_31,_pin2_32,_pin2_41,_pin2_42,_pin2_51,_pin2_52,_pin2_61,_pin2_62;


end;