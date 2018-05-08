1. 安装git，Git-2.17.0-64-bit.exe
2. 可选，安装图形化客户端工具TortoiseGit
3. 注册github账号或者gitee.com码云
4. 生成密钥：http://git.mydoc.io/?t=154712，将公钥上传到github或者码云中（以后本地再连接远程服务器，服务器就通过密钥验证身份）
5. 在idea中配置git以及github相关内容
6. 创建web项目，在VCS - Import into Version Control - Share Project On Github，将本地项目添加git版本管理，并上传到github中
7. 以后每当打开项目后或者提交项目前，先VCS - Git - Pull，从服务器端拉取最新的项目内容，然后查看是否有冲突代码；解决冲突后，再次
VCS - Commit （Ctrl+K）将你最新修改后的代码提交到版本服务器（添加注释），最后在有网络时，可以使用VCS - Git - Push（Ctrl+Shift+K）
将本地的代码新版本同步推送到git服务器（github上）