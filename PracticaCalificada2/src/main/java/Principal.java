import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class Principal {

    final private Map<Integer, List<Pair<Teacher, Boolean>>> allYearsTeachers = Map.ofEntries(
            new AbstractMap.SimpleImmutableEntry<>(
                    2020,
                    List.of(
                            new Pair<>( new ProfesorTP("Josefina"), true),
                            new Pair<>( new ProfesorTP("Edonisio"), true),
                            new Pair<>( new ProfesorTP("Edufasio"), false)
                    )
            ),
            new AbstractMap.SimpleImmutableEntry<>(
                    2019,
                    List.of(
                            new Pair<>( new ProfesorTP("Eduarda"), false),
                            new Pair<>( new ProfesorTP("Abelardo"), false),
                            new Pair<>( new ProfesorTP("Francisca"), false)
                    )
            )
    );
    private final int yearToCalculate;

    public Principal(int yearToCalculate) {
        this.yearToCalculate = yearToCalculate;
    }

    public float calculateGrades(final List<Pair<Integer, Float>> examsStudents, final boolean hasReachedMinimumClasses) {
        if (!examsStudents.isEmpty()) {
            boolean hasToIncreaseOneExtraPoint = teacherWithExtrasPoint();


            float gradesSum       = 0f;
            int   gradesWeightSum = 0;
            for (Pair<Integer, Float> examGrade : examsStudents) {
                gradesSum += (examGrade.first() * examGrade.second() / 100);
                gradesWeightSum += examGrade.first();
            }



            if (isMaxScore(gradesWeightSum)) {
                return minAsistClasses(hasReachedMinimumClasses, hasToIncreaseOneExtraPoint, gradesSum);
            } else return isOverMaxScore(gradesWeightSum);


        } else {
            return 0f;
        }
    }

    private boolean teacherWithExtrasPoint() {
        boolean hasToIncreaseOneExtraPoint = false;

        for (Map.Entry<Integer, List<Pair<Teacher, Boolean>>> yearlyTeachers : allYearsTeachers.entrySet()) {
            if (yearToCalculate == yearlyTeachers.getKey()) {
                List<Pair<Teacher, Boolean>> teachers = yearlyTeachers.getValue();
                for (Pair<Teacher, Boolean> teacher : teachers) {
                    if (!teacher.second()) {
                        continue;
                    }
                    hasToIncreaseOneExtraPoint = true;
                }
            }
        }
        return hasToIncreaseOneExtraPoint;
    }

    private float minAsistClasses(boolean hasReachedMinimumClasses, boolean hasToIncreaseOneExtraPoint, float gradesSum) {
        if (hasReachedMinimumClasses) {
            return extraPoint(hasToIncreaseOneExtraPoint, gradesSum);
        } else {
            return 0f;
        }
    }

    private float isOverMaxScore(int gradesWeightSum) {
        if (gradesWeightSum > 100) {
            return -1f;
        }
        else {
            return -2f;
        }
    }

    private float extraPoint(boolean hasToIncreaseOneExtraPoint, float gradesSum) {
        if (hasToIncreaseOneExtraPoint) {
            return Float.min(10f, gradesSum + 1);
        } else {
            return gradesSum;
        }
    }

    private boolean isMaxScore(int gradesWeightSum) {
        return gradesWeightSum == 100;
    }

    public static void main(String[] args) {
     System.out.println("Hola");
    }
    //Imprimir el nombre de los profesores que est´an de acuerdo con otorgar puntos extras
    public void printTeacherExtraPoint(){
        if(teacherWithExtrasPoint()){
            for (Map.Entry<Integer, List<Pair<Teacher, Boolean>>> yearlyTeachers : allYearsTeachers.entrySet()) {
                List<Pair<Teacher, Boolean>> teachers = yearlyTeachers.getValue();
                for(Pair<Teacher,Boolean> teacher : teachers){
                    if(teacher.second() == true){
                        System.out.println(teacher.first());
                    }
                }
            }
        }else {
            System.out.println("No hay profesores que otorguen puntos extra");
        }

    }


}
