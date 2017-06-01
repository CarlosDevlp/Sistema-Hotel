<h2>BasicDao</h2>
<br/>
<h3>Creado por: Carlos Chavez Laguna</h3>
<br/>
<div class="contentContainer">
<ul class="inheritance">
<li>java.lang.Object</li>
<li>
<ul class="inheritance">
<li>dao.BasicDao</li>
</ul>
</li>
</ul>
<div class="description">
<ul class="blockList">
<li class="blockList">
<hr>
<br>
<pre>public abstract class <span class="typeNameLabel">BasicDao</span>
extends java.lang.Object</pre>
<div class="block">BasicDao, permite de manera automática conectarse a la base datos, además,
 de obtener los datos de las tablas y su posterior manipulación
 
 conexión: para modificar la conexión, cambie las constantes en assets.values.Constant
 
  
 Github:</div>
</li>
</ul>
</div>
<div class="summary">
<ul class="blockList">
<li class="blockList">
<!-- ======== CONSTRUCTOR SUMMARY ======== -->
<ul class="blockList">
<li class="blockList"><a name="constructor.summary">
<!--   -->
</a>
<h3>Constructor Summary</h3>
<table class="memberSummary" border="0" cellpadding="3" cellspacing="0" summary="Constructor Summary table, listing constructors, and an explanation">
<caption><span>Constructors</span><span class="tabEnd">&nbsp;</span></caption>
<tbody><tr>
<th class="colOne" scope="col">Constructor and Description</th>
</tr>
<tr class="altColor">
<td class="colOne"><code><span class="memberNameLink"><a href="../dao/BasicDao.html#BasicDao--">BasicDao</a></span>()</code>&nbsp;</td>
</tr>
</tbody></table>
</li>
</ul>
<!-- ========== METHOD SUMMARY =========== -->
<ul class="blockList">
<li class="blockList"><a name="method.summary">
<!--   -->
</a>
<h3>Method Summary</h3>
<table class="memberSummary" border="0" cellpadding="3" cellspacing="0" summary="Method Summary table, listing methods, and an explanation">
<caption><span id="t0" class="activeTableTab"><span>All Methods</span><span class="tabEnd">&nbsp;</span></span><span id="t1" class="tableTab"><span><a href="javascript:show(1);">Static Methods</a></span><span class="tabEnd">&nbsp;</span></span><span id="t4" class="tableTab"><span><a href="javascript:show(8);">Concrete Methods</a></span><span class="tabEnd">&nbsp;</span></span></caption>
<tbody><tr>
<th class="colFirst" scope="col">Modifier and Type</th>
<th class="colLast" scope="col">Method and Description</th>
</tr>
<tr id="i0" class="altColor">
<td class="colFirst"><code>static java.util.ArrayList&lt;java.util.Map&lt;java.lang.String,java.lang.String&gt;&gt;</code></td>
<td class="colLast"><code><span class="memberNameLink"><a href="../dao/BasicDao.html#call-java.lang.String-java.lang.String:A-">call</a></span>(java.lang.String&nbsp;name,
    java.lang.String[]&nbsp;params)</code>
<div class="block">CALL <br>
 permite llamar a procedimientos 
 ya definidos a nivel de SQL</div>
</td>
</tr>
<tr id="i1" class="rowColor">
<td class="colFirst"><code>static void</code></td>
<td class="colLast"><code><span class="memberNameLink"><a href="../dao/BasicDao.html#delete-java.lang.String-java.lang.String-">delete</a></span>(java.lang.String&nbsp;table,
      java.lang.String&nbsp;where)</code>
<div class="block">DELETE <br>
eliminar datos <br>
Permite insertar datos nuevos a una tabla</div>
</td>
</tr>
<tr id="i2" class="altColor">
<td class="colFirst"><code>static void</code></td>
<td class="colLast"><code><span class="memberNameLink"><a href="../dao/BasicDao.html#init--">init</a></span>()</code>
<div class="block">INIT, permite inicializar la conexión de BasicDao con la base de datos.</div>
</td>
</tr>
<tr id="i3" class="rowColor">
<td class="colFirst"><code>static void</code></td>
<td class="colLast"><code><span class="memberNameLink"><a href="../dao/BasicDao.html#insert-java.lang.String-java.lang.String:A-java.lang.String:A-">insert</a></span>(java.lang.String&nbsp;table,
      java.lang.String[]&nbsp;cols,
      java.lang.String[]&nbsp;values)</code>
<div class="block">INSERT <br>
Inserción de datos <br>
Permite insertar datos nuevos a una tabla</div>
</td>
</tr>
<tr id="i4" class="altColor">
<td class="colFirst"><code>static boolean</code></td>
<td class="colLast"><code><span class="memberNameLink"><a href="../dao/BasicDao.html#isTableEmpty-java.lang.String-">isTableEmpty</a></span>(java.lang.String&nbsp;table)</code>
<div class="block">verificación de tabla vacía <br>
Permite verificar si la tabla está vacía</div>
</td>
</tr>
<tr id="i5" class="rowColor">
<td class="colFirst"><code>static java.util.ArrayList&lt;java.util.Map&lt;java.lang.String,java.lang.String&gt;&gt;</code></td>
<td class="colLast"><code><span class="memberNameLink"><a href="../dao/BasicDao.html#select-java.lang.String:A-java.lang.String:A-java.lang.String:A-java.lang.String-">select</a></span>(java.lang.String[]&nbsp;table,
      java.lang.String[]&nbsp;col,
      java.lang.String[]&nbsp;match,
      java.lang.String&nbsp;where)</code>
<div class="block">SELECT JOIN <br>
Selección  con joins <br>
Permite seleccionar los datos de varias tablas al mismo tiempo con Joins</div>
</td>
</tr>
<tr id="i6" class="altColor">
<td class="colFirst"><code>static java.util.ArrayList&lt;java.util.Map&lt;java.lang.String,java.lang.String&gt;&gt;</code></td>
<td class="colLast"><code><span class="memberNameLink"><a href="../dao/BasicDao.html#select-java.lang.String-java.lang.String:A-java.lang.String-">select</a></span>(java.lang.String&nbsp;table,
      java.lang.String[]&nbsp;col,
      java.lang.String&nbsp;where)</code>
<div class="block">SELECT <br>
Selección  básica <br>
Permite seleccionar los datos de una tabla</div>
</td>
</tr>
<tr id="i7" class="rowColor">
<td class="colFirst"><code>static java.util.Map&lt;java.lang.String,java.lang.String&gt;</code></td>
<td class="colLast"><code><span class="memberNameLink"><a href="../dao/BasicDao.html#selectLastRow-java.lang.String-java.lang.String:A-java.lang.String-">selectLastRow</a></span>(java.lang.String&nbsp;table,
             java.lang.String[]&nbsp;col,
             java.lang.String&nbsp;columnToOrderBy)</code>
<div class="block">seleccionar última fila <br>
Permite seleccionar la última fila de la tabla <br></div>
</td>
</tr>
<tr id="i8" class="altColor">
<td class="colFirst"><code>static void</code></td>
<td class="colLast"><code><span class="memberNameLink"><a href="../dao/BasicDao.html#update-java.lang.String-java.lang.String:A-java.lang.String:A-java.lang.String-">update</a></span>(java.lang.String&nbsp;table,
      java.lang.String[]&nbsp;cols,
      java.lang.String[]&nbsp;values,
      java.lang.String&nbsp;where)</code>
<div class="block">UPDATE <br>
actualización de datos.</div>
</td>
</tr>
</tbody></table>
<ul class="blockList">
<li class="blockList"><a name="methods.inherited.from.class.java.lang.Object">
<!--   -->
</a>
<h3>Methods inherited from class&nbsp;java.lang.Object</h3>
<code>clone, equals, finalize, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait</code></li>
</ul>
</li>
</ul>
</li>
</ul>
</div>
<div class="details">
<ul class="blockList">
<li class="blockList">
<!-- ========= CONSTRUCTOR DETAIL ======== -->
<ul class="blockList">
<li class="blockList"><a name="constructor.detail">
<!--   -->
</a>
<h3>Constructor Detail</h3>
<a name="BasicDao--">
<!--   -->
</a>
<ul class="blockListLast">
<li class="blockList">
<h4>BasicDao</h4>
<pre>public&nbsp;BasicDao()</pre>
</li>
</ul>
</li>
</ul>
<!-- ============ METHOD DETAIL ========== -->
<ul class="blockList">
<li class="blockList"><a name="method.detail">
<!--   -->
</a>
<h3>Method Detail</h3>
<a name="init--">
<!--   -->
</a>
<ul class="blockList">
<li class="blockList">
<h4>init</h4>
<pre>public static&nbsp;void&nbsp;init()</pre>
<div class="block">INIT, permite inicializar la conexión de BasicDao con la base de datos.</div>
</li>
</ul>
<a name="select-java.lang.String-java.lang.String:A-java.lang.String-">
<!--   -->
</a>
<ul class="blockList">
<li class="blockList">
<h4>select</h4>
<pre>public static&nbsp;java.util.ArrayList&lt;java.util.Map&lt;java.lang.String,java.lang.String&gt;&gt;&nbsp;select(java.lang.String&nbsp;table,
                                                                                           java.lang.String[]&nbsp;col,
                                                                                           java.lang.String&nbsp;where)</pre>
<div class="block">SELECT <br>
Selección  básica <br>
Permite seleccionar los datos de una tabla</div>
<dl>
<dt><span class="paramLabel">Parameters:</span></dt>
<dd><code>table</code> - nombre de la tabla</dd>
<dd><code>col</code> - nombres de las columnas en un array de strings: new String {'col1','col2'}</dd>
<dd><code>where</code> - condición que debe cumplir los datos que se están opteniendo</dd>
<dt><span class="returnLabel">Returns:</span></dt>
<dd>retorna una matriz de resultado.</dd>
</dl>
</li>
</ul>
<a name="select-java.lang.String:A-java.lang.String:A-java.lang.String:A-java.lang.String-">
<!--   -->
</a>
<ul class="blockList">
<li class="blockList">
<h4>select</h4>
<pre>public static&nbsp;java.util.ArrayList&lt;java.util.Map&lt;java.lang.String,java.lang.String&gt;&gt;&nbsp;select(java.lang.String[]&nbsp;table,
                                                                                           java.lang.String[]&nbsp;col,
                                                                                           java.lang.String[]&nbsp;match,
                                                                                           java.lang.String&nbsp;where)</pre>
<div class="block">SELECT JOIN <br>
Selección  con joins <br>
Permite seleccionar los datos de varias tablas al mismo tiempo con Joins</div>
<dl>
<dt><span class="paramLabel">Parameters:</span></dt>
<dd><code>table</code> - arreglo con las tablas que harán join</dd>
<dd><code>col</code> - nombres de las columnas en un array de strings: new String {'col1','col2'}</dd>
<dd><code>match</code> - columnas que hacen el match (llave foranea)</dd>
<dd><code>where</code> - condición que debe cumplir los datos que se están opteniendo</dd>
<dt><span class="returnLabel">Returns:</span></dt>
<dd>retorna una matriz de resultado.</dd>
</dl>
</li>
</ul>
<a name="insert-java.lang.String-java.lang.String:A-java.lang.String:A-">
<!--   -->
</a>
<ul class="blockList">
<li class="blockList">
<h4>insert</h4>
<pre>public static&nbsp;void&nbsp;insert(java.lang.String&nbsp;table,
                          java.lang.String[]&nbsp;cols,
                          java.lang.String[]&nbsp;values)</pre>
<div class="block">INSERT <br>
Inserción de datos <br>
Permite insertar datos nuevos a una tabla</div>
<dl>
<dt><span class="paramLabel">Parameters:</span></dt>
<dd><code>table</code> - nombre de la tabla</dd>
<dd><code>cols</code> - nombres de las columnas en un array de strings: new String {'col1','col2'}</dd>
<dd><code>values</code> - valores a insertar, tienen que ser el mismo número que las cols</dd>
</dl>
</li>
</ul>
<a name="delete-java.lang.String-java.lang.String-">
<!--   -->
</a>
<ul class="blockList">
<li class="blockList">
<h4>delete</h4>
<pre>public static&nbsp;void&nbsp;delete(java.lang.String&nbsp;table,
                          java.lang.String&nbsp;where)</pre>
<div class="block">DELETE <br>
eliminar datos <br>
Permite insertar datos nuevos a una tabla</div>
<dl>
<dt><span class="paramLabel">Parameters:</span></dt>
<dd><code>table</code> - nombre de la tabla</dd>
<dd><code>where</code> - condición para identificar las filas que se van a eliminar</dd>
</dl>
</li>
</ul>
<a name="update-java.lang.String-java.lang.String:A-java.lang.String:A-java.lang.String-">
<!--   -->
</a>
<ul class="blockList">
<li class="blockList">
<h4>update</h4>
<pre>public static&nbsp;void&nbsp;update(java.lang.String&nbsp;table,
                          java.lang.String[]&nbsp;cols,
                          java.lang.String[]&nbsp;values,
                          java.lang.String&nbsp;where)</pre>
<div class="block">UPDATE <br>
actualización de datos. <br>
Permite actualizar los datos en la base de datos.</div>
<dl>
<dt><span class="paramLabel">Parameters:</span></dt>
<dd><code>table</code> - arreglo con las tablas que harán join</dd>
<dd><code>cols</code> - columnas que se van a actualizar</dd>
<dd><code>values</code> - valores con las que se van a actualizar</dd>
<dd><code>where</code> - condición para identificar las filas que se van a actualizar</dd>
</dl>
</li>
</ul>
<a name="isTableEmpty-java.lang.String-">
<!--   -->
</a>
<ul class="blockList">
<li class="blockList">
<h4>isTableEmpty</h4>
<pre>public static&nbsp;boolean&nbsp;isTableEmpty(java.lang.String&nbsp;table)</pre>
<div class="block">verificación de tabla vacía <br>
Permite verificar si la tabla está vacía</div>
<dl>
<dt><span class="paramLabel">Parameters:</span></dt>
<dd><code>table</code> - nombre de la tabla a evaluar</dd>
<dt><span class="returnLabel">Returns:</span></dt>
<dd>verdadero o falso si la tabla está vacía</dd>
</dl>
</li>
</ul>
<a name="selectLastRow-java.lang.String-java.lang.String:A-java.lang.String-">
<!--   -->
</a>
<ul class="blockList">
<li class="blockList">
<h4>selectLastRow</h4>
<pre>public static&nbsp;java.util.Map&lt;java.lang.String,java.lang.String&gt;&nbsp;selectLastRow(java.lang.String&nbsp;table,
                                                                             java.lang.String[]&nbsp;col,
                                                                             java.lang.String&nbsp;columnToOrderBy)</pre>
<div class="block">seleccionar última fila <br>
Permite seleccionar la última fila de la tabla <br></div>
<dl>
<dt><span class="paramLabel">Parameters:</span></dt>
<dd><code>table</code> - nombre de la tabla a evaluar</dd>
<dd><code>col</code> - nombre de las columnas a seleccionar de esa fila</dd>
<dd><code>columnToOrderBy</code> - nombre de la columna por la que se ordenará</dd>
<dt><span class="returnLabel">Returns:</span></dt>
<dd>arreglo con los datos de la fila</dd>
</dl>
</li>
</ul>
<a name="call-java.lang.String-java.lang.String:A-">
<!--   -->
</a>
<ul class="blockListLast">
<li class="blockList">
<h4>call</h4>
<pre>public static&nbsp;java.util.ArrayList&lt;java.util.Map&lt;java.lang.String,java.lang.String&gt;&gt;&nbsp;call(java.lang.String&nbsp;name,
                                                                                         java.lang.String[]&nbsp;params)</pre>
<div class="block">CALL <br>
 permite llamar a procedimientos 
 ya definidos a nivel de SQL</div>
<dl>
<dt><span class="paramLabel">Parameters:</span></dt>
<dd><code>name</code> - es el nombre del procedimiento a llamar</dd>
<dd><code>params</code> - son los parámetros (sus valores) en el orden que el procedimiento requiere.</dd>
<dt><span class="returnLabel">Returns:</span></dt>
<dd>si el procedimiento a llamar retorna un valor o conjunto de valores, 
 recepcionarlo.</dd>
</dl>
</li>
</ul>
</li>
</ul>
</li>
</ul>
</div>
</div>
