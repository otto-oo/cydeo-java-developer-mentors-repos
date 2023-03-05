
ConfigApp , add annotation  @ComponentScan("com.cydeo")

CartRepositoryImpl , add annotation @Component

CartServiceImpl, add annotations @Component and @AllArgsConstructor

StockServiceImpl, add annotation @Component

Cart and Product classes, add (@Getter @Setter @NoArgsConstructor) 
                              or just add @Data (there is no final field, so it will have no-arg constructor)

