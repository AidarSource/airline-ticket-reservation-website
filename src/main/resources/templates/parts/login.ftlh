<#macro login path formName>

<!--Bootstrap CSS -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

<link rel="stylesheet" href="styles/login.css" />

<div class="container">
    <div class="row">
        <div class="col-md-5 mx-auto">
            <div class="myform form ">
                <div class="logo mb-3">
                    <div class="col-md-12 text-center">
                        <h1>${formName}</h1>
                    </div>
                </div>
                <form action="${path}" method="post">
                    <div class="form-group">
                        <label>Логин</label>
                        <input type="text" name="username" class="form-control" placeholder="Логинді еңгізініз">
                    </div>
                    <div class="form-group">
                        <label>Пароль</label>
                        <input type="password" name="password" class="form-control" placeholder="Парольді еңгізініз">
                    </div>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <#if formName == "Login">
                    <div class="col-md-12 text-center ">
                        <button type="submit" class="btn btn-block mybtn btn-primary tx-tfm">LOGIN</button>
                    </div>
                    <#else>
                    <div class="col-md-12 text-center ">
                        <button type="submit" class="btn btn-block mybtn btn-primary tx-tfm">Register</button>
                    </div>
                    </#if>
                    <#if formName == "Login">
                    <div class="col-md-12 ">
                        <div class="login-or">
                            <hr class="hr-or">
                        </div>
                    </div>
                    <div class="form-group">
                        <p class="text-center">Аккаунтініз жоқ па? <a href="/registration" id="signup">Осы жерде тіркелу</a></p>
                    </div>
                    <#else>
                    <div class="col-md-12 ">
                        <div class="login-or">
                            <hr class="hr-or">
                        </div>
                    </div>
                    <div class="form-group">
                        <p class="text-center">Аккаунтініз бар ма? <a href="/login" id="login">Осы жерде кіру</a></p>
                    </div>
                    </#if>
                </form>
            </div>
        </div>
    </div>
</div>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <button class="btn btn-primary" type="submit">Шығу</button>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
</form>
</#macro>