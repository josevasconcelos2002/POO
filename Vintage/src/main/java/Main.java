import Artigos.Malas;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args)
    {
        Malas mala = new Malas("158aasd545641", "Mala das boas", "nike",
                             15, 10, 16, 0, "Pelo de leao", LocalDate.now(), Malas.Edicao.STANDARD);
        System.out.println(mala.toString());
    }
}