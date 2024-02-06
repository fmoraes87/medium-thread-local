package com.company;

import java.util.Properties;

public class Notepad {

  private static final String MSG_REQUIRE_CONTEXT = "Require Context";


  /** Context identifier */
  public static final String USER_CURRENT_LOCATION = "USER_CURRENT_LOCATION";
  public static final String USER_ID = "USER_ID";

  //Esta linha declara uma variável estática do tipo ThreadLocal que é parametrizada com o tipo Properties.
  // Isso significa que esta variável threadLocal será compartilhada
  // por todas as instâncias da classe em que está declarada, mas cada thread que acessa essa variável terá
  // sua própria cópia da instância de Properties associada a ela.
  private static final ThreadLocal<Properties> threadLocal;

  // Initialize current thread
  static {
    threadLocal = new ThreadLocal<>();
  }

  /**
   * Set current context
   *
   * @param context
   */

  //Este método setCtx precisa ser sincronizado porque ele está manipulando uma variável estática compartilhada threadLocal.
  //Quando múltiplas threads acessam métodos estáticos simultaneamente, pode haver uma situação em que uma
  // thread está definindo o contexto (Properties) enquanto outra thread está acessando ou modificando o mesmo contexto.
  // Isso pode levar a resultados inesperados, como perda de dados ou corrupção de informações.
  //Ao adicionar a palavra-chave synchronized ao método, garantimos que apenas uma thread pode executar esse
  // método por vez. Isso evita que duas ou mais threads acessem ou modifiquem a variável compartilhada simultaneamente
  // , garantindo a consistência e integridade dos dados.
  public static synchronized void setCtx(Properties context) {
    threadLocal.set(context);
  }

  /**
   * Get Current Context
   *
   * @return
   */
  public static synchronized Properties getCtx() {
    return threadLocal.get();
  }

  /**
   * Clean current config.
   */
  public static void clean() {
    threadLocal.remove();

  }

  /**
   * Set Context value
   *
   * @param property
   * @param value
   */
  public static void setContextValue(String property, String value) {
    Properties ctx = getCtx();

    if (ctx == null || property == null) {
      return;
    }
    //
    if (value == null || value.length() == 0) {
      ctx.remove(property);
    } else {
      ctx.setProperty(property, value);
    }

  }

  /**
   *	Get global Value of Context
   *  @param property property
   *  @return value or ""
   */
  public static String getContextValue (String property)
  {

    var ctx = getCtx();

    if (ctx==null || property == null) {
      throw new IllegalArgumentException (MSG_REQUIRE_CONTEXT);
    }
    return ctx.getProperty(property, "");
  }	//	getContext


}
