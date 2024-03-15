public enum MenuRouter {
    ;
}

//        CREATMENU("creteMenu",scanner-> {
//            try {
//                MenuController.getInsteance().menuCreatTable(scanner);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//            return true;
//        }),
//        DELETEMENU("DeleteMenu",scanner-> {
//            try {
//                MenuController.getInsteance().menuDeleteTable(scanner);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//            return true;
//        }),
//        INSERTMENU("InsertMenu",scanner-> {
//            try {
//                MenuController.getInsteance().menuInsertData(scanner);
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//            return true;
//        }),
//
//        EXIT("exit",scanner-> {
//            System.out.println("Menu handling has ended.");
//            return false;
//        }),
//
//        ERROR("error", scanner-> {
//            System.out.println("ERROR 유효하지 않는 문자입니다.");
//            return true;
//        });
//
//        private final String name;
//        private final Predicate<Scanner> Predicate;
//
//        MenuRouter(String name, Predicate<Scanner> Predicate) {
//            this.name = name;
//            this.Predicate = Predicate;
//        }
//        public static boolean getMenuRouter(Scanner sc){
//            System.out.println("exit, createMenu, dereteMenu, selectMenu");
//            String str = sc.next();
//            return Stream.of(MenuRouter.values())
//                    .filter(i->i.name.equals(str))
//                    .findAny().orElse(ERROR)
//                    .Predicate.test(sc);
//        }
//
//}
//
