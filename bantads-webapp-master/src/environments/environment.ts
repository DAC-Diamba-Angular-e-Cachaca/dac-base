// This file can be replaced during build by using the `fileReplacements` array.
// `ng build` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
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
    usuario: 'http://localhost:5000/usuarios',
    conta: 'http://localhost:5000/contas',
    cliente: 'http://localhost:5000/clientes',
    analise: 'http://localhost:5000/analises',
    gerente: 'http://localhost:5000/gerentes',
    gatewayDireta: 'http://localhost:5000'
  },
  // url: {
  //   usuario: 'http://host.docker.internal:bantads-autenticacao:5001/usuarios',
  //   conta: 'http://host.docker.internal:bantads-conta:5003/contas',
  //   cliente: 'http://host.docker.internal:bantads-cliente:5002/clientes',
  //   analise: 'http://host.docker.internal:bantads-cliente:5002/analises',
  //   gerente: 'http://host.docker.internal:bantads-gerente:5004/gerentes'
  // },
  localStorage: {
    tokenSessao: 'tokenSessao',
    usuarioLogado: 'usuarioLogado'
  }
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/plugins/zone-error';  // Included with Angular CLI.
