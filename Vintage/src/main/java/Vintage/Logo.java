package Vintage;

import Vintage.Menu;

public class Logo {
    public static void logo(){
        Menu.limpaTerminal();
        System.out.println("\n\n\n\n");
        String logo = "\tVVVVVVVV           VVVVVVVV  iiii                             tttt\n" +
                "\tV::::::V           V::::::V i::::i                         ttt:::t\n" +
                "\tV::::::V           V::::::V  iiii                          t:::::t\n" +
                "\tV::::::V           V::::::V                                t:::::t\n" +
                "\t V:::::V           V:::::V iiiiiii nnnn  nnnnnnnn    ttttttt:::::ttttttt      aaaaaaaaaaaaa      ggggggggg   ggggg    eeeeeeeeeeee\n" +
                "\t  V:::::V         V:::::V  i:::::i n:::nn::::::::nn  t:::::::::::::::::t      a::::::::::::a    g:::::::::ggg::::g  ee::::::::::::ee\n" +
                "\t   V:::::V       V:::::V    i::::i n::::::::::::::nn t:::::::::::::::::t      aaaaaaaaa:::::a  g:::::::::::::::::g e::::::eeeee:::::ee\n" +
                "\t    V:::::V     V:::::V     i::::i nn:::::::::::::::ntttttt:::::::tttttt               a::::a g::::::ggggg::::::gge::::::e     e:::::e\n" +
                "\t     V:::::V   V:::::V      i::::i   n:::::nnnn:::::n      t:::::t              aaaaaaa:::::a g:::::g     g:::::g e:::::::eeeee::::::e\n" +
                "\t      V:::::V V:::::V       i::::i   n::::n    n::::n      t:::::t            aa::::::::::::a g:::::g     g:::::g e:::::::::::::::::e \n" +
                "\t       V:::::V:::::V        i::::i   n::::n    n::::n      t:::::t           a::::aaaa::::::a g:::::g     g:::::g e::::::eeeeeeeeeee\n" +
                "\t        V:::::::::V         i::::i   n::::n    n::::n      t:::::t    tttttta::::a    a:::::a g::::::g    g:::::g e:::::::e\n" +
                "\t         V:::::::V         i::::::i  n::::n    n::::n      t::::::tttt:::::ta::::a    a:::::a g:::::::ggggg:::::g e::::::::e\n" +
                "\t          V:::::V          i::::::i  n::::n    n::::n      tt::::::::::::::ta:::::aaaa::::::a  g::::::::::::::::g  e::::::::eeeeeeee\n" +
                "\t           V:::V           i::::::i  n::::n    n::::n        tt:::::::::::tt a::::::::::aa:::a  gg::::::::::::::g   ee:::::::::::::e\n" +
                "\t            VVV            iiiiiiii  nnnnnn    nnnnnn          ttttttttttt    aaaaaaaaaa  aaaa    gggggggg::::::g     eeeeeeeeeeeeee\n" +
                "\t                                                                                                          g:::::g\n" +
                "\t                                                                                              gggggg      g:::::g\n" +
                "\t                                                                                              g:::::gg   gg:::::g\n" +
                "\t                                                                                               g::::::ggg:::::::g\n" +
                "\t                                                                                                gg:::::::::::::g\n" +
                "\t                                                                                                  ggg::::::ggg\n" +
                "\t                                                                                                     gggggg\n" +
                "\t                                                                                                                                      \n"+
                "\t                                                                                                                                      \n"+
                "\t                                                                                                                                      \n"+
                "\t                                                                                                                by Ana, Jose and Paulo\n";
        System.out.println(Menu.ANSI_GOLD + logo + Menu.ANSI_RESET);
    }
}
