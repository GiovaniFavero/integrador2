

# somatorio de todas as disciplinas e horarios indisponiveis de um professor 
s.t. conflito_horario_professor:  = 0


# somatorio de todas as disciplinas e horarios de laboratorio = ao céu de 50% da carga horária
_15arc_11_Lab_1 + _15arc_12_Lab_1 + _15arc_21_Lab_1 + _15arc_22_Lab_1 + _15arc_31_Lab_1 + _15arc_32_Lab_1 + _15arc_41_Lab_1 + _15arc_42_Lab_1 + _15arc_51_Lab_1 + _15arc_52_Lab_1 + _15arc_61_Lab_1 + _15arc_62_Lab_1 = 1
_25proI_11_Lab_1 + _25proI_12_Lab_1 + _25proI_21_Lab_1 + _25proI_22_Lab_1 + _25proI_31_Lab_1 + _25proI_32_Lab_1 + _25proI_41_Lab_1 + _25proI_42_Lab_1 + _25proI_51_Lab_1 + _25proI_52_Lab_1 + _25proI_61_Lab_1 + _25proI_62_Lab_1 = 1

# horario arbitrario de disciplina
s.t. horario_arbitrario_disciplina: _15mad_11 = 1;
_15mad_12 = 1;
