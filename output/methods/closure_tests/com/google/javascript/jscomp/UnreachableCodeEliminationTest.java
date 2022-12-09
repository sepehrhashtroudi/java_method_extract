@Override [EOL] protected CompilerPass getProcessor(Compiler compiler) { [EOL]     return new UnreachableCodeElimination(compiler, removeNoOpStatements); [EOL] } <line_num>: 26,29
@Override [EOL] public void setUp() throws Exception { [EOL]     super.setUp(); [EOL]     removeNoOpStatements = true; [EOL] } <line_num>: 31,34
public void testRemoveUnreachableCode() { [EOL]     test("function foo(){switch(foo){case 1:x=1;return;break;" + "case 2:{x=2;return;break}default:}}", "function foo(){switch(foo){case 1:x=1;return;" + "case 2:{x=2}default:}}"); [EOL]     test("function bar(){if(foo)x=1;else if(bar){return;x=2}" + "else{x=3;return;x=4}return 5;x=5}", "function bar(){if(foo)x=1;else if(bar){return}" + "else{x=3;return}return 5}"); [EOL]     test("function foo(){if(x==3)return;x=4;y++;while(y==4){return;x=3}}", "function foo(){if(x==3)return;x=4;y++;while(y==4){return}}"); [EOL]     test("function baz(){for(i=0;i<n;i++){x=3;break;x=4}" + "do{x=2;break;x=4}while(x==4);" + "while(i<4){x=3;return;x=6}}", "function baz(){for(i=0;i<n;){x=3;break}" + "do{x=2;break}while(x==4);" + "while(i<4){x=3;return}}"); [EOL]     test("function foo(){if(x==3){return}return 5;while(y==4){x++;return;x=4}}", "function foo(){if(x==3){return}return 5}"); [EOL]     test("function foo(){return 3;for(;y==4;){x++;return;x=4}}", "function foo(){return 3}"); [EOL]     test("function foo(){try{x=3;return x+1;x=5}catch(e){x=4;return 5;x=5}}", "function foo(){try{x=3;return x+1}catch(e){x=4;return 5}}"); [EOL]     test("function foo(){try{x=3;return x+1;x=5}finally{x=4;return 5;x=5}}", "function foo(){try{x=3;return x+1}finally{x=4;return 5}}"); [EOL]     test("function foo(){try{x=3;return x+1;x=5}catch(e){x=3;return;x=2}" + "finally{x=4;return 5;x=5}}", "function foo(){try{x=3;return x+1}catch(e){x=3;return}" + "finally{x=4;return 5}}"); [EOL]     test("function foo(){x=3;if(x==4){x=5;return;x=6}else{x=7}return 5;x=3}", "function foo(){x=3;if(x==4){x=5;return}else{x=7}return 5}"); [EOL]     test("function foo() { return 1; var x = 2; var y = 10; return 2;}", "function foo() { var y; var x; return 1}"); [EOL]     test("function foo() { return 1; x = 2; y = 10; return 2;}", "function foo(){ return 1}"); [EOL] } <line_num>: 36,94
public void testRemoveUselessNameStatements() { [EOL]     test("a;", ""); [EOL]     test("a.b;", ""); [EOL]     test("a.b.MyClass.prototype.memberName;", ""); [EOL] } <line_num>: 96,100
public void testRemoveUselessStrings() { [EOL]     test("'a';", ""); [EOL] } <line_num>: 102,104
public void testNoRemoveUseStrict() { [EOL]     test("'use strict';", "'use strict'"); [EOL] } <line_num>: 106,108
public void testNoRemoveUselessNameStatements() { [EOL]     removeNoOpStatements = false; [EOL]     testSame("a;"); [EOL]     testSame("a.b;"); [EOL]     testSame("a.b.MyClass.prototype.memberName;"); [EOL] } <line_num>: 110,115
public void testRemoveDo() { [EOL]     test("do { print(1); break } while(1)", "do { print(1); break } while(1)"); [EOL]     test("while(1) { break; do { print(1); break } while(1) }", "while(1) { break; do {} while(1) }"); [EOL] } <line_num>: 117,121
public void testRemoveUselessLiteralValueStatements() { [EOL]     test("true;", ""); [EOL]     test("'hi';", ""); [EOL]     test("if (x) 1;", ""); [EOL]     test("while (x) 1;", "while (x);"); [EOL]     test("do 1; while (x);", "do ; while (x);"); [EOL]     test("for (;;) 1;", "for (;;);"); [EOL]     test("switch(x){case 1:true;case 2:'hi';default:true}", "switch(x){case 1:case 2:default:}"); [EOL] } <line_num>: 123,132
public void testConditionalDeadCode() { [EOL]     test("function f() { if (1) return 5; else return 5; x = 1}", "function f() { if (1) return 5; else return 5; }"); [EOL] } <line_num>: 134,137
public void testSwitchCase() { [EOL]     test("function f() { switch(x) { default: return 5; foo()}}", "function f() { switch(x) { default: return 5;}}"); [EOL]     test("function f() { switch(x) { default: return; case 1: foo(); bar()}}", "function f() { switch(x) { default: return; case 1: foo(); bar()}}"); [EOL]     test("function f() { switch(x) { default: return; case 1: return 5;bar()}}", "function f() { switch(x) { default: return; case 1: return 5;}}"); [EOL] } <line_num>: 139,146
public void testTryCatchFinally() { [EOL]     testSame("try {foo()} catch (e) {bar()}"); [EOL]     testSame("try { try {foo()} catch (e) {bar()}} catch (x) {bar()}"); [EOL]     test("try {var x = 1} catch (e) {e()}", "try {var x = 1} finally {}"); [EOL]     test("try {var x = 1} catch (e) {e()} finally {x()}", " try {var x = 1}                 finally {x()}"); [EOL]     test("try {var x = 1} catch (e) {e()} finally {}", "try {var x = 1} finally {}"); [EOL]     testSame("try {var x = 1} finally {x()}"); [EOL]     testSame("try {var x = 1} finally {}"); [EOL]     test("function f() {return; try{var x = 1}catch(e){} }", "function f() {var x;}"); [EOL] } <line_num>: 148,160
public void testRemovalRequiresRedeclaration() { [EOL]     test("while(1) { break; var x = 1}", "var x; while(1) { break } "); [EOL]     test("while(1) { break; var x=1; var y=1}", "var y; var x; while(1) { break } "); [EOL] } <line_num>: 162,166
public void testAssignPropertyOnCreatedObject() { [EOL]     testSame("this.foo = 3;"); [EOL]     testSame("a.foo = 3;"); [EOL]     testSame("bar().foo = 3;"); [EOL]     testSame("({}).foo = bar();"); [EOL]     testSame("(new X()).foo = 3;"); [EOL]     test("({}).foo = 3;", ""); [EOL]     test("(function() {}).prototype.toString = function(){};", ""); [EOL]     test("(function() {}).prototype['toString'] = function(){};", ""); [EOL]     test("(function() {}).prototype[f] = function(){};", ""); [EOL] } <line_num>: 168,179
public void testUselessUnconditionalReturn() { [EOL]     test("function foo() { return }", " function foo() { }"); [EOL]     test("function foo() { return; return; x=1 }", "function foo() { }"); [EOL]     test("function foo() { return; return; var x=1}", "function foo() {var x}"); [EOL]     test("function foo() { return; function bar() {} }", "function foo() {         function bar() {} }"); [EOL]     testSame("function foo() { return 5 }"); [EOL]     test("function f() {switch (a) { case 'a': return}}", "function f() {switch (a) { case 'a': }}"); [EOL]     testSame("function f() {switch (a) { case 'a': case foo(): }}"); [EOL]     testSame("function f() {switch (a) {" + " default: return; case 'a': alert(1)}}"); [EOL]     testSame("function f() {switch (a) {" + " case 'a': return; default: alert(1)}}"); [EOL] } <line_num>: 181,196
public void testUnlessUnconditionalContinue() { [EOL]     test("for(;1;) {continue}", " for(;1;) {}"); [EOL]     test("for(;0;) {continue}", " for(;0;) {}"); [EOL]     testSame("X: for(;1;) { for(;1;) { if (x()) {continue X} x = 1}}"); [EOL]     test("for(;1;) { X: for(;1;) { if (x()) {continue X} }}", "for(;1;) { X: for(;1;) { if (x()) {}}}"); [EOL]     test("do { continue } while(1);", "do {  } while(1);"); [EOL] } <line_num>: 198,207
public void testUnlessUnconditonalBreak() { [EOL]     test("switch (a) { case 'a': break }", "switch (a) { case 'a': }"); [EOL]     test("switch (a) { case 'a': break; case foo(): }", "switch (a) { case 'a':        case foo(): }"); [EOL]     test("switch (a) { default: break; case 'a': }", "switch (a) { default:        case 'a': }"); [EOL]     testSame("switch (a) { case 'a': alert(a); break; default: alert(a); }"); [EOL]     testSame("switch (a) { default: alert(a); break; case 'a': alert(a); }"); [EOL]     test("X: {switch (a) { case 'a': break X}}", "X: {switch (a) { case 'a': }}"); [EOL]     testSame("X: {switch (a) { case 'a': if (a()) {break X}  a = 1}}"); [EOL]     test("X: {switch (a) { case 'a': if (a()) {break X}}}", "X: {switch (a) { case 'a': if (a()) {}}}"); [EOL]     test("X: {switch (a) { case 'a': if (a()) {break X}}}", "X: {switch (a) { case 'a': if (a()) {}}}"); [EOL]     testSame("do { break } while(1);"); [EOL]     testSame("for(;1;) { break }"); [EOL] } <line_num>: 209,233
public void testCascadedRemovalOfUnlessUnconditonalJumps() { [EOL]     test("switch (a) { case 'a': break; case 'b': break; case 'c': break }", "switch (a) { case 'a': break; case 'b': case 'c': }"); [EOL]     test("switch (a) { case 'a': break; case 'b': case 'c': }", "switch (a) { case 'a': case 'b': case 'c': }"); [EOL]     test("function foo() {" + "  switch (a) { case 'a':return; case 'b':return; case 'c':return }}", "function foo() { switch (a) { case 'a':return; case 'b': case 'c': }}"); [EOL]     test("function foo() {" + "  switch (a) { case 'a':return; case 'b': case 'c': }}", "function foo() { switch (a) { case 'a': case 'b': case 'c': }}"); [EOL]     testSame("function foo() {" + "switch (a) { case 'a':return 2; case 'b':return 1}}"); [EOL] } <line_num>: 235,251
public void testIssue311() { [EOL]     test("function a(b) {\n" + "  switch (b.v) {\n" + "    case 'SWITCH':\n" + "      if (b.i >= 0) {\n" + "        return b.o;\n" + "      } else {\n" + "        return;\n" + "      }\n" + "      break;\n" + "  }\n" + "}", "function a(b) {\n" + "  switch (b.v) {\n" + "    case 'SWITCH':\n" + "      if (b.i >= 0) {\n" + "        return b.o;\n" + "      } else {\n" + "      }\n" + "  }\n" + "}"); [EOL] } <line_num>: 253,274
public void testIssue4177428a() { [EOL]     test("f = function() {\n" + "  var action;\n" + "  a: {\n" + "    var proto = null;\n" + "    try {\n" + "      proto = new Proto\n" + "    } finally {\n" + "      action = proto;\n" + "      break a\n" + "    }\n" + "  }\n" + "  alert(action)\n" + "};", "f = function() {\n" + "  var action;\n" + "  a: {\n" + "    var proto = null;\n" + "    try {\n" + "      proto = new Proto\n" + "    } finally {\n" + "      action = proto;\n" + "    }\n" + "  }\n" + "  alert(action)\n" + "};"); [EOL] } <line_num>: 276,304
public void testIssue4177428b() { [EOL]     test("f = function() {\n" + "  var action;\n" + "  a: {\n" + "    var proto = null;\n" + "    try {\n" + "    try {\n" + "      proto = new Proto\n" + "    } finally {\n" + "      action = proto;\n" + "      break a\n" + "    }\n" + "    } finally {\n" + "    }\n" + "  }\n" + "  alert(action)\n" + "};", "f = function() {\n" + "  var action;\n" + "  a: {\n" + "    var proto = null;\n" + "    try {\n" + "    try {\n" + "      proto = new Proto\n" + "    } finally {\n" + "      action = proto;\n" + "      break a\n" + "    }\n" + "    } finally {\n" + "    }\n" + "  }\n" + "  alert(action)\n" + "};"); [EOL] } <line_num>: 306,341
public void testIssue4177428c() { [EOL]     test("f = function() {\n" + "  var action;\n" + "  a: {\n" + "    var proto = null;\n" + "    try {\n" + "    } finally {\n" + "    try {\n" + "      proto = new Proto\n" + "    } finally {\n" + "      action = proto;\n" + "      break a\n" + "    }\n" + "    }\n" + "  }\n" + "  alert(action)\n" + "};", "f = function() {\n" + "  var action;\n" + "  a: {\n" + "    var proto = null;\n" + "    try {\n" + "    } finally {\n" + "    try {\n" + "      proto = new Proto\n" + "    } finally {\n" + "      action = proto;\n" + "    }\n" + "    }\n" + "  }\n" + "  alert(action)\n" + "};"); [EOL] } <line_num>: 343,377
public void testIssue4177428_continue() { [EOL]     test("f = function() {\n" + "  var action;\n" + "  a: do {\n" + "    var proto = null;\n" + "    try {\n" + "      proto = new Proto\n" + "    } finally {\n" + "      action = proto;\n" + "      continue a\n" + "    }\n" + "  } while(false)\n" + "  alert(action)\n" + "};", "f = function() {\n" + "  var action;\n" + "  a: do {\n" + "    var proto = null;\n" + "    try {\n" + "      proto = new Proto\n" + "    } finally {\n" + "      action = proto;\n" + "    }\n" + "  } while (false)\n" + "  alert(action)\n" + "};"); [EOL] } <line_num>: 379,407
public void testIssue4177428_return() { [EOL]     test("f = function() {\n" + "  var action;\n" + "  a: {\n" + "    var proto = null;\n" + "    try {\n" + "      proto = new Proto\n" + "    } finally {\n" + "      action = proto;\n" + "      return\n" + "    }\n" + "  }\n" + "  alert(action)\n" + "};", "f = function() {\n" + "  var action;\n" + "  a: {\n" + "    var proto = null;\n" + "    try {\n" + "      proto = new Proto\n" + "    } finally {\n" + "      action = proto;\n" + "    }\n" + "  }\n" + "};"); [EOL] } <line_num>: 409,436
public void testIssue4177428_multifinally() { [EOL]     testSame("a: {\n" + " try {\n" + " try {\n" + " } finally {\n" + "   break a;\n" + " }\n" + " } finally {\n" + "   x = 1;\n" + " }\n" + "}"); [EOL] } <line_num>: 438,450
public void testIssue5215541_deadVarDeclar() { [EOL]     testSame("throw 1; var x"); [EOL]     testSame("throw 1; function x() {}"); [EOL]     testSame("throw 1; var x; var y;"); [EOL]     test("throw 1; var x = foo", "var x; throw 1"); [EOL] } <line_num>: 452,457
public void testForInLoop() { [EOL]     testSame("for(var x in y) {}"); [EOL] } <line_num>: 459,461