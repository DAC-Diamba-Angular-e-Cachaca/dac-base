export const environment = {
  production: true,
  menuItems: {
    admin: {
      home: '/admin/home',
      items: [{ name: 'Cadastrar Gerente', link: '/admin/novo-gerente' }],
    },
    gerente: {
      home: '/',
      items: [{ name: '', link: '' }],
    },
    cliente: {
      home: '/',
      items: [{ name: '', link: '' }],
    },
  },
  url: {
    usuario: 'http://host.docker.internal:bantads-gateway:5000/usuarios',
    conta: 'http://host.docker.internal:bantads-gateway:5000/contas',
    cliente: 'http://host.docker.internal:bantads-gateway:5000/clientes',
    analise: 'http://host.docker.internal:bantads-gateway:5000/analises',
    gerente: 'http://host.docker.internal:bantads-gateway:5000/gerentes'
  },
  localStorage: {
    tokenSessao: 'tokenSessao',
    usuarioLogado: 'usuarioLogado'
  }
};
