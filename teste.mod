var _2_11,binary;
var _2_11_Labb,binary;
var _2_12,binary;
var _2_12_Labb,binary;
var _2_21,binary;
var _2_21_Labb,binary;
var _2_22,binary;
var _2_22_Labb,binary;
var _2_31,binary;
var _2_31_Labb,binary;
var _2_32,binary;
var _2_32_Labb,binary;
var _2_41,binary;
var _2_41_Labb,binary;
var _2_42,binary;
var _2_42_Labb,binary;
var _2_51,binary;
var _2_51_Labb,binary;
var _2_52,binary;
var _2_52_Labb,binary;
var _2_61,binary;
var _2_61_Labb,binary;
var _2_62,binary;
var _2_62_Labb,binary;
var _1_11,binary;
var _1_11_Lab,binary;
var _1_12,binary;
var _1_12_Lab,binary;
var _1_21,binary;
var _1_21_Lab,binary;
var _1_22,binary;
var _1_22_Lab,binary;
var _1_31,binary;
var _1_31_Lab,binary;
var _1_32,binary;
var _1_32_Lab,binary;
var _1_41,binary;
var _1_41_Lab,binary;
var _1_42,binary;
var _1_42_Lab,binary;
var _1_51,binary;
var _1_51_Lab,binary;
var _1_52,binary;
var _1_52_Lab,binary;
var _1_61,binary;
var _1_61_Lab,binary;
var _1_62,binary;
var _1_62_Lab,binary;

maximize z: 
10*_2_11+
10*_2_12+
12*_2_21+
12*_2_22+
10*_2_31+
10*_2_32+
10*_2_41+
10*_2_42+
10*_2_51+
10*_2_52+
10*_2_61+
10*_2_62+
12*_1_11+
12*_1_12+
10*_1_21+
10*_1_22+
10*_1_31+
10*_1_32+
10*_1_41+
10*_1_42+
10*_1_51+
10*_1_52+
10*_1_61+
10*_1_62+
10*_2_11_Labb+
10*_2_12_Labb+
12*_2_21_Labb+
12*_2_22_Labb+
10*_2_31_Labb+
10*_2_32_Labb+
10*_2_41_Labb+
10*_2_42_Labb+
10*_2_51_Labb+
10*_2_52_Labb+
10*_2_61_Labb+
10*_2_62_Labb+
12*_1_11_Lab+
12*_1_12_Lab+
10*_1_21_Lab+
10*_1_22_Lab+
10*_1_31_Lab+
10*_1_32_Lab+
10*_1_41_Lab+
10*_1_42_Lab+
10*_1_51_Lab+
10*_1_52_Lab+
10*_1_61_Lab+
10*_1_62_Lab;

# somatorio de todas as variaveis da disciplina = carga horaria

s.t. carga_horaria: _2_11+_2_11_Labb+_2_12+_2_12_Labb+_2_21+_2_21_Labb+_2_22+_2_22_Labb+_2_31+_2_31_Labb+_2_32+_2_32_Labb+_2_41+_2_41_Labb+_2_42+_2_42_Labb+_2_51+_2_51_Labb+_2_52+_2_52_Labb+_2_61+_2_61_Labb+_2_62+_2_62_Labb = 1;
 s.t. carga_horaria1:_1_11+_1_11_Lab+_1_12+_1_12_Lab+_1_21+_1_21_Lab+_1_22+_1_22_Lab+_1_31+_1_31_Lab+_1_32+_1_32_Lab+_1_41+_1_41_Lab+_1_42+_1_42_Lab+_1_51+_1_51_Lab+_1_52+_1_52_Lab+_1_61+_1_61_Lab+_1_62+_1_62_Lab = 1;

# somatorio_de_todas as disciplinas de um professor por horario <=1 
 s.t. conflito_horario_professor0:_1_11+_1_11_Lab<= 1; 
s.t. conflito_horario_professor1:_1_12+_1_12_Lab<= 1; 
s.t. conflito_horario_professor2:_1_21+_1_21_Lab<= 1; 
s.t. conflito_horario_professor3:_1_22+_1_22_Lab<= 1; 
s.t. conflito_horario_professor4:_1_31+_1_31_Lab<= 1; 
s.t. conflito_horario_professor5:_1_32+_1_32_Lab<= 1; 
s.t. conflito_horario_professor6:_1_41+_1_41_Lab<= 1; 
s.t. conflito_horario_professor7:_1_42+_1_42_Lab<= 1; 
s.t. conflito_horario_professor8:_1_51+_1_51_Lab<= 1; 
s.t. conflito_horario_professor9:_1_52+_1_52_Lab<= 1; 
s.t. conflito_horario_professor10:_1_61+_1_61_Lab<= 1; 
s.t. conflito_horario_professor11:_1_62+_1_62_Lab<= 1; 
s.t. conflito_horario_professor12:_2_11+_2_11_Labb<= 1; 
s.t. conflito_horario_professor13:_2_12+_2_12_Labb<= 1; 
s.t. conflito_horario_professor14:_2_21+_2_21_Labb<= 1; 
s.t. conflito_horario_professor15:_2_22+_2_22_Labb<= 1; 
s.t. conflito_horario_professor16:_2_31+_2_31_Labb<= 1; 
s.t. conflito_horario_professor17:_2_32+_2_32_Labb<= 1; 
s.t. conflito_horario_professor18:_2_41+_2_41_Labb<= 1; 
s.t. conflito_horario_professor19:_2_42+_2_42_Labb<= 1; 
s.t. conflito_horario_professor20:_2_51+_2_51_Labb<= 1; 
s.t. conflito_horario_professor21:_2_52+_2_52_Labb<= 1; 
s.t. conflito_horario_professor22:_2_61+_2_61_Labb<= 1; 
s.t. conflito_horario_professor23:_2_62+_2_62_Labb<= 1; 


# somatorio de todas as disciplinas de uma turma por horario <= 1
s.t. conflito_horario_turma0:_2_11+_2_11_Labb+_1_11+_1_11_Lab<= 1; 
s.t. conflito_horario_turma1:_2_12+_2_12_Labb+_1_12+_1_12_Lab<= 1; 
s.t. conflito_horario_turma2:_2_21+_2_21_Labb+_1_21+_1_21_Lab<= 1; 
s.t. conflito_horario_turma3:_2_22+_2_22_Labb+_1_22+_1_22_Lab<= 1; 
s.t. conflito_horario_turma4:_2_31+_2_31_Labb+_1_31+_1_31_Lab<= 1; 
s.t. conflito_horario_turma5:_2_32+_2_32_Labb+_1_32+_1_32_Lab<= 1; 
s.t. conflito_horario_turma6:_2_41+_2_41_Labb+_1_41+_1_41_Lab<= 1; 
s.t. conflito_horario_turma7:_2_42+_2_42_Labb+_1_42+_1_42_Lab<= 1; 
s.t. conflito_horario_turma8:_2_51+_2_51_Labb+_1_51+_1_51_Lab<= 1; 
s.t. conflito_horario_turma9:_2_52+_2_52_Labb+_1_52+_1_52_Lab<= 1; 
s.t. conflito_horario_turma10:_2_61+_2_61_Labb+_1_61+_1_61_Lab<= 1; 
s.t. conflito_horario_turma11:_2_62+_2_62_Labb+_1_62+_1_62_Lab<= 1; 

# somatorio de todas as disciplinas e horarios indisponiveis de um professor = 0 
s.t. conflito_horario_professor_indisponivel1:_2_21+_2_21_Labb= 0;
s.t. conflito_horario_professor_indisponivel2:_2_22+_2_22_Labb= 0;
s.t. conflito_horario_professor_indisponivel3:_1_11+_1_11_Lab= 0;
s.t. conflito_horario_professor_indisponivel4:_1_12+_1_12_Lab= 0;
# somatorio de todas as disciplinas e horarios de laboratorio = ao céu de 50porcento da carga horárias.t. somatorio_ceu0:_2_11_Labb+_2_12_Labb+_2_21_Labb+_2_22_Labb+_2_31_Labb+_2_32_Labb+_2_41_Labb+_2_42_Labb+_2_51_Labb+_2_52_Labb+_2_61_Labb+_2_62_Labb=1;s.t. somatorio_ceu1:_1_11_Lab+_1_12_Lab+_1_21_Lab+_1_22_Lab+_1_31_Lab+_1_32_Lab+_1_41_Lab+_1_42_Lab+_1_51_Lab+_1_52_Lab+_1_61_Lab+_1_62_Lab=1;
# horario arbitrario de disciplina

solve;
display _2_11,_2_11_Labb,_2_12,_2_12_Labb,_2_21,_2_21_Labb,_2_22,_2_22_Labb,_2_31,_2_31_Labb,_2_32,_2_32_Labb,_2_41,_2_41_Labb,_2_42,_2_42_Labb,_2_51,_2_51_Labb,_2_52,_2_52_Labb,_2_61,_2_61_Labb,_2_62,_2_62_Labb,_1_11,_1_11_Lab,_1_12,_1_12_Lab,_1_21,_1_21_Lab,_1_22,_1_22_Lab,_1_31,_1_31_Lab,_1_32,_1_32_Lab,_1_41,_1_41_Lab,_1_42,_1_42_Lab,_1_51,_1_51_Lab,_1_52,_1_52_Lab,_1_61,_1_61_Lab,_1_62,_1_62_Lab;


end;var _2_11,binary;
var _2_11_Labb,binary;
var _2_12,binary;
var _2_12_Labb,binary;
var _2_21,binary;
var _2_21_Labb,binary;
var _2_22,binary;
var _2_22_Labb,binary;
var _2_31,binary;
var _2_31_Labb,binary;
var _2_32,binary;
var _2_32_Labb,binary;
var _2_41,binary;
var _2_41_Labb,binary;
var _2_42,binary;
var _2_42_Labb,binary;
var _2_51,binary;
var _2_51_Labb,binary;
var _2_52,binary;
var _2_52_Labb,binary;
var _2_61,binary;
var _2_61_Labb,binary;
var _2_62,binary;
var _2_62_Labb,binary;
var _1_11,binary;
var _1_11_Lab,binary;
var _1_12,binary;
var _1_12_Lab,binary;
var _1_21,binary;
var _1_21_Lab,binary;
var _1_22,binary;
var _1_22_Lab,binary;
var _1_31,binary;
var _1_31_Lab,binary;
var _1_32,binary;
var _1_32_Lab,binary;
var _1_41,binary;
var _1_41_Lab,binary;
var _1_42,binary;
var _1_42_Lab,binary;
var _1_51,binary;
var _1_51_Lab,binary;
var _1_52,binary;
var _1_52_Lab,binary;
var _1_61,binary;
var _1_61_Lab,binary;
var _1_62,binary;
var _1_62_Lab,binary;

maximize z: 
10*_2_11+
10*_2_12+
12*_2_21+
12*_2_22+
10*_2_31+
10*_2_32+
10*_2_41+
10*_2_42+
10*_2_51+
10*_2_52+
10*_2_61+
10*_2_62+
12*_1_11+
12*_1_12+
10*_1_21+
10*_1_22+
10*_1_31+
10*_1_32+
10*_1_41+
10*_1_42+
10*_1_51+
10*_1_52+
10*_1_61+
10*_1_62+
10*_2_11_Labb+
10*_2_12_Labb+
12*_2_21_Labb+
12*_2_22_Labb+
10*_2_31_Labb+
10*_2_32_Labb+
10*_2_41_Labb+
10*_2_42_Labb+
10*_2_51_Labb+
10*_2_52_Labb+
10*_2_61_Labb+
10*_2_62_Labb+
12*_1_11_Lab+
12*_1_12_Lab+
10*_1_21_Lab+
10*_1_22_Lab+
10*_1_31_Lab+
10*_1_32_Lab+
10*_1_41_Lab+
10*_1_42_Lab+
10*_1_51_Lab+
10*_1_52_Lab+
10*_1_61_Lab+
10*_1_62_Lab;

# somatorio de todas as variaveis da disciplina = carga horaria

s.t. carga_horaria: _2_11+_2_11_Labb+_2_12+_2_12_Labb+_2_21+_2_21_Labb+_2_22+_2_22_Labb+_2_31+_2_31_Labb+_2_32+_2_32_Labb+_2_41+_2_41_Labb+_2_42+_2_42_Labb+_2_51+_2_51_Labb+_2_52+_2_52_Labb+_2_61+_2_61_Labb+_2_62+_2_62_Labb = 1;
 s.t. carga_horaria1:_1_11+_1_11_Lab+_1_12+_1_12_Lab+_1_21+_1_21_Lab+_1_22+_1_22_Lab+_1_31+_1_31_Lab+_1_32+_1_32_Lab+_1_41+_1_41_Lab+_1_42+_1_42_Lab+_1_51+_1_51_Lab+_1_52+_1_52_Lab+_1_61+_1_61_Lab+_1_62+_1_62_Lab = 1;

# somatorio_de_todas as disciplinas de um professor por horario <=1 
 s.t. conflito_horario_professor0:_1_11+_1_11_Lab<= 1; 
s.t. conflito_horario_professor1:_1_12+_1_12_Lab<= 1; 
s.t. conflito_horario_professor2:_1_21+_1_21_Lab<= 1; 
s.t. conflito_horario_professor3:_1_22+_1_22_Lab<= 1; 
s.t. conflito_horario_professor4:_1_31+_1_31_Lab<= 1; 
s.t. conflito_horario_professor5:_1_32+_1_32_Lab<= 1; 
s.t. conflito_horario_professor6:_1_41+_1_41_Lab<= 1; 
s.t. conflito_horario_professor7:_1_42+_1_42_Lab<= 1; 
s.t. conflito_horario_professor8:_1_51+_1_51_Lab<= 1; 
s.t. conflito_horario_professor9:_1_52+_1_52_Lab<= 1; 
s.t. conflito_horario_professor10:_1_61+_1_61_Lab<= 1; 
s.t. conflito_horario_professor11:_1_62+_1_62_Lab<= 1; 
s.t. conflito_horario_professor12:_2_11+_2_11_Labb<= 1; 
s.t. conflito_horario_professor13:_2_12+_2_12_Labb<= 1; 
s.t. conflito_horario_professor14:_2_21+_2_21_Labb<= 1; 
s.t. conflito_horario_professor15:_2_22+_2_22_Labb<= 1; 
s.t. conflito_horario_professor16:_2_31+_2_31_Labb<= 1; 
s.t. conflito_horario_professor17:_2_32+_2_32_Labb<= 1; 
s.t. conflito_horario_professor18:_2_41+_2_41_Labb<= 1; 
s.t. conflito_horario_professor19:_2_42+_2_42_Labb<= 1; 
s.t. conflito_horario_professor20:_2_51+_2_51_Labb<= 1; 
s.t. conflito_horario_professor21:_2_52+_2_52_Labb<= 1; 
s.t. conflito_horario_professor22:_2_61+_2_61_Labb<= 1; 
s.t. conflito_horario_professor23:_2_62+_2_62_Labb<= 1; 


# somatorio de todas as disciplinas de uma turma por horario <= 1
s.t. conflito_horario_turma0:_2_11+_2_11_Labb+_1_11+_1_11_Lab<= 1; 
s.t. conflito_horario_turma1:_2_12+_2_12_Labb+_1_12+_1_12_Lab<= 1; 
s.t. conflito_horario_turma2:_2_21+_2_21_Labb+_1_21+_1_21_Lab<= 1; 
s.t. conflito_horario_turma3:_2_22+_2_22_Labb+_1_22+_1_22_Lab<= 1; 
s.t. conflito_horario_turma4:_2_31+_2_31_Labb+_1_31+_1_31_Lab<= 1; 
s.t. conflito_horario_turma5:_2_32+_2_32_Labb+_1_32+_1_32_Lab<= 1; 
s.t. conflito_horario_turma6:_2_41+_2_41_Labb+_1_41+_1_41_Lab<= 1; 
s.t. conflito_horario_turma7:_2_42+_2_42_Labb+_1_42+_1_42_Lab<= 1; 
s.t. conflito_horario_turma8:_2_51+_2_51_Labb+_1_51+_1_51_Lab<= 1; 
s.t. conflito_horario_turma9:_2_52+_2_52_Labb+_1_52+_1_52_Lab<= 1; 
s.t. conflito_horario_turma10:_2_61+_2_61_Labb+_1_61+_1_61_Lab<= 1; 
s.t. conflito_horario_turma11:_2_62+_2_62_Labb+_1_62+_1_62_Lab<= 1; 

# somatorio de todas as disciplinas e horarios indisponiveis de um professor = 0 
s.t. conflito_horario_professor_indisponivel1:_2_21+_2_21_Labb= 0;
s.t. conflito_horario_professor_indisponivel2:_2_22+_2_22_Labb= 0;
s.t. conflito_horario_professor_indisponivel3:_1_11+_1_11_Lab= 0;
s.t. conflito_horario_professor_indisponivel4:_1_12+_1_12_Lab= 0;
# somatorio de todas as disciplinas e horarios de laboratorio = ao céu de 50porcento da carga horárias.t. somatorio_ceu0:_2_11_Labb+_2_12_Labb+_2_21_Labb+_2_22_Labb+_2_31_Labb+_2_32_Labb+_2_41_Labb+_2_42_Labb+_2_51_Labb+_2_52_Labb+_2_61_Labb+_2_62_Labb=1;s.t. somatorio_ceu1:_1_11_Lab+_1_12_Lab+_1_21_Lab+_1_22_Lab+_1_31_Lab+_1_32_Lab+_1_41_Lab+_1_42_Lab+_1_51_Lab+_1_52_Lab+_1_61_Lab+_1_62_Lab=1;
# horario arbitrario de disciplina

solve;
display _2_11,_2_11_Labb,_2_12,_2_12_Labb,_2_21,_2_21_Labb,_2_22,_2_22_Labb,_2_31,_2_31_Labb,_2_32,_2_32_Labb,_2_41,_2_41_Labb,_2_42,_2_42_Labb,_2_51,_2_51_Labb,_2_52,_2_52_Labb,_2_61,_2_61_Labb,_2_62,_2_62_Labb,_1_11,_1_11_Lab,_1_12,_1_12_Lab,_1_21,_1_21_Lab,_1_22,_1_22_Lab,_1_31,_1_31_Lab,_1_32,_1_32_Lab,_1_41,_1_41_Lab,_1_42,_1_42_Lab,_1_51,_1_51_Lab,_1_52,_1_52_Lab,_1_61,_1_61_Lab,_1_62,_1_62_Lab;


end;