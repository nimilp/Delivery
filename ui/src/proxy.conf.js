const PROXY_CONFIG = [
  {
    context: ['/api/**'],
    target: 'http://localhost:8081/keralakitchen',
    secure: false,
    changeOrigin: true,
    logLevel: 'debug',
    pathRewrite: {
      "^/api": ""
    },
    "changeOrigin": true
  }
]

module.exports = PROXY_CONFIG;
