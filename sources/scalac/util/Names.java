/*     ____ ____  ____ ____  ______                                     *\
**    / __// __ \/ __// __ \/ ____/    SOcos COmpiles Scala             **
**  __\_ \/ /_/ / /__/ /_/ /\_ \       (c) 2002, LAMP/EPFL              **
** /_____/\____/\___/\____/____/                                        **
**
** $Id$
\*                                                                      */
package scalac.util;

import scalac.symtab.Symbol;

public class Names {

    private static final String LOCAL_PREFIX = "local$";
    private static final String MIXIN_PREFIX = "mixin$";
    private static final String OUTER_PREFIX = "outer$";
    private static final String SUPER_PREFIX = "super$";
    private static final String TUPLE_FIELD_PREFIX = "_";
    private static final String scala_Tuple_PREFIX = "scala.Tuple";
    private static final String scala_Function_PREFIX = "scala.Function";

    public static Name LOCAL(Symbol clasz) {
        return Name.fromString(LOCAL_PREFIX + clasz.name);
    }

    public static Name MIXIN(Symbol member) {
        Name name = Name.fromString(MIXIN_PREFIX + member.owner().name
            + (member.isInitializer() ? INLINED_INITIALIZER : member.name));
        if (member.name.isTypeName()) name = name.toTypeName();
        return name;
    }

    public static Name OUTER(Symbol constructor) {
        assert constructor.isConstructor() : Debug.show(constructor);
        Symbol clasz = constructor.constructorClass();
        Symbol[] constructors = clasz.allConstructors().alternativeSymbols();
        int index = 0;
        while (constructors[index] != constructor) index++;
        String name = OUTER_PREFIX + index +"$"+ clasz.owner().name;
        return Name.fromString(name);
    }

    public static Name OUTER(Symbol constructor, Symbol member) {
        Name name = Name.fromString(OUTER(constructor) + "$" + member.name);
        if (member.name.isTypeName()) name = name.toTypeName();
        return name;
    }

    public static Name SUPER(Symbol method) {
        return Name.fromString(SUPER_PREFIX + method.name);
    }

    public static Name TUPLE_FIELD(int index) {
        return Name.fromString(TUPLE_FIELD_PREFIX + index);
    }

    public static Name scala_Tuple(int arity) {
        return Name.fromString(scala_Tuple_PREFIX + arity);
    }

    public static Name scala_Function(int arity) {
        return Name.fromString(scala_Function_PREFIX + arity);
    }

    public static final Name ERROR = Name.ERROR;
    public static final Name NOSYMBOL = Name.fromString("<none>");
    public static final Name EMPTY = Name.fromString("");
    public static final Name IMPORT_WILDCARD = Name.fromString("_");
    public static final Name PATTERN_WILDCARD = Name.fromString("_");
    public static final Name COMPOUND_NAME = Name.fromString("<ct>");
    public static final Name ANON_CLASS_NAME = Name.fromString("$anon");
    public static final Name ZERO = Name.fromString("<zero>");
    public static final Name STAR = Name.fromString("*");
    public static final Name ROOT = Name.fromString("<root>");

    public static final Name CONSTRUCTOR = Name.fromString("<init>");
    public static final Name INITIALIZER = Name.fromString("<init>");
    public static final Name INLINED_INITIALIZER = Name.fromString("$init$");

    public static final Name _EQ = encode("_=");
    public static final Name MINUS = encode("-");
    public static final Name PLUS = encode("+");
    public static final Name TILDE = encode("~");
    public static final Name EQEQ = encode("==");
    public static final Name BANG = encode("!");
    public static final Name BANGEQ = encode("!=");
    public static final Name BARBAR = encode("||");
    public static final Name AMPAMP = encode("&&");
    public static final Name COLONCOLON = encode("::");

    public static final Name All = Name.fromString("All");
    public static final Name AllRef = Name.fromString("AllRef");
    public static final Name Any = Name.fromString("Any");
    public static final Name AnyVal = Name.fromString("AnyVal");
    public static final Name AnyRef = Name.fromString("AnyRef");
    public static final Name Array = Name.fromString("Array");
    public static final Name Byte = Name.fromString("Byte");
    public static final Name Catch = Name.fromString("Catch");
    public static final Name Char = Name.fromString("Char");
    public static final Name Boolean = Name.fromString("Boolean");
    public static final Name Do = Name.fromString("Do");
    public static final Name Double = Name.fromString("Double");
    public static final Name Element = Name.fromString("Element");
    public static final Name Finally = Name.fromString("Finally");
    public static final Name Float = Name.fromString("Float");
    public static final Name Function = Name.fromString("Function");
    public static final Name Int = Name.fromString("Int");
    public static final Name Labelled = Name.fromString("Labelled");
    public static final Name List = Name.fromString("List");
    public static final Name Long = Name.fromString("Long");
    public static final Name Nil = Name.fromString("Nil");
    public static final Name Object = Name.fromString("Object");
    public static final Name PartialFunction = Name.fromString("PartialFunction");
    public static final Name Predef = Name.fromString("Predef");
    public static final Name ScalaRunTime = Name.fromString("ScalaRunTime");
    public static final Name Seq = Name.fromString("Seq");
    public static final Name Short = Name.fromString("Short");
    public static final Name String = Name.fromString("String");
    public static final Name Symbol = Name.fromString("Symbol");
    public static final Name Throwable = Name.fromString("Throwable");
    public static final Name Try = Name.fromString("Try");
    public static final Name Tuple = Name.fromString("Tuple");
    public static final Name Unit = Name.fromString("Unit");
    public static final Name While = Name.fromString("While");
    public static final Name apply = Name.fromString("apply");
    public static final Name array = Name.fromString("array");
    public static final Name asInstanceOf = Name.fromString("asInstanceOf");
    public static final Name box = Name.fromString("box");
    public static final Name coerce = Name.fromString("coerce");
    public static final Name elem = Name.fromString("elem");
    public static final Name elements = Name.fromString("elements");
    public static final Name fail = Name.fromString("fail");
    public static final Name false_ = Name.fromString("false");
    public static final Name filter = Name.fromString("filter");
    public static final Name flatmap = Name.fromString("flatMap");
    public static final Name foreach = Name.fromString("foreach");
    public static final Name getClass = Name.fromString("getClass");
    public static final Name hashCode = Name.fromString("hashCode");
    public static final Name hasNext = Name.fromString("hasNext");
    public static final Name head = Name.fromString("head");
    public static final Name isInstanceOf = Name.fromString("isInstanceOf");
    public static final Name isDefinedAt = Name.fromString("isDefinedAt");
    public static final Name isEmpty = Name.fromString("isEmpty");
    public static final Name java = Name.fromString("java");
    public static final Name java_lang = Name.fromString("java.lang");
    public static final Name java_lang_Object = Name.fromString("java.lang.Object");
    public static final Name java_lang_String = Name.fromString("java.lang.String");
    public static final Name java_lang_Throwable = Name.fromString("java.lang.Throwable");
    public static final Name lang = Name.fromString("lang");
    public static final Name length = Name.fromString("length");
    public static final Name match = Name.fromString("match");
    public static final Name map = Name.fromString("map");
    public static final Name nobinding = Name.fromString("nobinding");
    public static final Name next = Name.fromString("next");
    public static final Name null_ = Name.fromString("null");
    public static final Name predef = Name.fromString("predef");
    public static final Name print = Name.fromString("print");
    public static final Name runtime = Name.fromString("runtime");
    public static final Name scala = Name.fromString("scala");
    public static final Name xml = Name.fromString("xml");
    public static final Name scala_COLONCOLON = Name.fromString("scala." + COLONCOLON);
    public static final Name scala_All = Name.fromString("scala.All");
    public static final Name scala_AllRef = Name.fromString("scala.AllRef");
    public static final Name scala_Any = Name.fromString("scala.Any");
    public static final Name scala_AnyRef = Name.fromString("scala.AnyRef");
    public static final Name scala_AnyVal = Name.fromString("scala.AnyVal");
    public static final Name scala_Array = Name.fromString("scala.Array");
    public static final Name scala_Boolean = Name.fromString("scala.Boolean");
    public static final Name scala_Byte = Name.fromString("scala.Byte");
    public static final Name scala_Case = Name.fromString("scala.Case");
    public static final Name scala_Char = Name.fromString("scala.Char");
    public static final Name scala_Console = Name.fromString("scala.Console");
    public static final Name scala_Double = Name.fromString("scala.Double");
    public static final Name scala_Float = Name.fromString("scala.Float");
    public static final Name scala_Function = Name.fromString(scala_Function_PREFIX);
    public static final Name scala_Int = Name.fromString("scala.Int");

    public static final Name scala_Iterable = Name.fromString("scala.Iterable");
    public static final Name scala_Iterator = Name.fromString("scala.Iterator");
    public static final Name scala_List = Name.fromString("scala.List");
    public static final Name scala_Long = Name.fromString("scala.Long");
    public static final Name scala_MatchError = Name.fromString("scala.MatchError");
    public static final Name scala_Nil = Name.fromString("scala.Nil");
    public static final Name scala_Object = Name.fromString("scala.Object");
    public static final Name scala_PartialFunction = Name.fromString("scala.PartialFunction");
    public static final Name scala_Predef = Name.fromString("scala.Predef");
    public static final Name scala_Ref = Name.fromString("scala.Ref");
    public static final Name scala_Seq = Name.fromString("scala.Seq");
    public static final Name scala_Short = Name.fromString("scala.Short");
    public static final Name scala_Symbol = Name.fromString("scala.Symbol");
    public static final Name scala_Tuple = Name.fromString("scala.Tuple");
    public static final Name scala_Unit = Name.fromString("scala.Unit");
    public static final Name scala_runtime = Name.fromString("scala.runtime");
    public static final Name scala_runtime_RunTime = Name.fromString("scala.runtime.RunTime");
    public static final Name eq = Name.fromString("eq");
    public static final Name equals = Name.fromString("equals");
    public static final Name tail = Name.fromString("tail");
    public static final Name toString = Name.fromString("toString");
    public static final Name that = Name.fromString("that");
    public static final Name that1 = Name.fromString("that1");
    public static final Name this_ = Name.fromString("this");
    public static final Name throw_ = Name.fromString("throw");
    public static final Name true_ = Name.fromString("true");
    public static final Name update = Name.fromString("update");

	public static final Name tag = Name.fromString("$tag");

    public static final Name
        ZNOT = encode("!"),
        ZAND = encode("&&"),
        ZOR  = encode("||"),
        NOT  = encode("~"),
        ADD  = encode("+"),
        SUB  = encode("-"),
        MUL  = encode("*"),
        DIV  = encode("/"),
        MOD  = encode("%"),
        EQ   = encode("=="),
        NE   = encode("!="),
        LT   = encode("<"),
        LE   = encode("<="),
        GT   = encode(">"),
        GE   = encode(">="),
        OR   = encode("|"),
        XOR  = encode("^"),
        AND  = encode("&"),
        LSL  = encode("<<"),
        LSR  = encode(">>>"),
        ASR  = encode(">>");

    private static Name encode(String string) {
        return NameTransformer.encode(Name.fromString(string));
    }
}

